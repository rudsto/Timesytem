package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.Utils.PassordUtil;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Testklasse for BrukerController.
 */
@WebMvcTest(controllers = BrukerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class EndrePassordControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrukerService brukerService;
    @MockBean
    private ProsjektService prosjektService;
    @MockBean
    private TimeService timeService;
    @InjectMocks
    private BrukerController brukerController;




    /**
     * Tester at redirect går til "/endrepassord" når brukeren er logget inn.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void brukerLoggetInnTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        HttpServletRequest request = new MockHttpServletRequest();
        Bruker testBruker = new Bruker();

        LoginUtil.loggInnBruker(request, testBruker);

        mockMvc.perform(get("/endrepassord").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("endrepassord"));
    }

    /**
     * Tester at redirect går tilbake til "/login" dersom bruker ikke er logget inn.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void brukerIkkeLoggetInnTest() throws Exception {
        mockMvc.perform(get("/endrepassord"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("login"))
                .andExpect(flash().attributeExists("feilmelding"))
                .andExpect(flash().attribute("feilmelding", "Du må være logget inn for å endre passord."));
    }
    
    /**
     * Tester at redirect går til "/endrepassord_suksess" etter endret passord.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void endrePassordSuksessTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        HttpServletRequest request = new MockHttpServletRequest();
        Bruker testBruker = new Bruker();
        
        testBruker.setSalt(PassordUtil.genererTilfeldigSalt());
        testBruker.setHash(PassordUtil.hashMedSalt("passs", testBruker.getSalt()));

        LoginUtil.loggInnBruker(request, testBruker);

        mockMvc.perform(post("/endrepassord")
        		.param("gammeltpassord", "passs")
        		.param("nyttpassord", "12345")
                .param("gjentattnyttPassord", "12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("endrepassord_suksess"))
                .andExpect(flash().attributeExists("bruker"));
    }
    
    /**
     * Tester at redirect går til "/endrepassord" etter ikke lykket endring av passord.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void endrePassordIkkeSuksessTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        HttpServletRequest request = new MockHttpServletRequest();
        Bruker testBruker = new Bruker();
        
        testBruker.setSalt(PassordUtil.genererTilfeldigSalt());
        testBruker.setHash(PassordUtil.hashMedSalt("passs", testBruker.getSalt()));

        LoginUtil.loggInnBruker(request, testBruker);

        mockMvc.perform(post("/endrepassord")
        		.param("gammeltpassord", "12345")
        		.param("nyttpassord", "125")
                .param("gjentattnyttPassord", "14345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("endrepassord"))
                .andExpect(flash().attributeExists("endrePassordFeilmelding"));
    }
}

