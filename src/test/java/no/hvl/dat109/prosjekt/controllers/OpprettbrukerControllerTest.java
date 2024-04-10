package no.hvl.dat109.prosjekt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.Utils.PassordUtil;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.repo.BrukerRepo;
import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

/**
 * Metode for å teste funksjonalitet i OpprettbrukerController.
 */
@WebMvcTest(controllers = OpprettbrukerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class OpprettbrukerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private BrukerRepo brukerRepo;
    @InjectMocks
    private OpprettbrukerController opprettbrukerController;
    @MockBean
    private BrukerService brukerService;
    @MockBean
    private ProsjektService prosjektService;
    @MockBean
    private TimeService timeService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     *
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
//    @Test
//    public void postPaameldingTest() throws Exception {
//
//        HttpServletRequest request = new MockHttpServletRequest();
//        RedirectAttributes ra = mock(RedirectAttributes.class);
//        Model model = mock(Model.class);
//
//        MockedStatic<LoginUtil> mocked = mockStatic(LoginUtil.class);
//
//        Bruker bruker = new Bruker();
//        bruker.setMobil("12345678");
//
//        when(brukerService.finnBrukerMedMobil("12345678")).thenReturn(null);
//        when(PassordUtil.genererTilfeldigSalt()).thenReturn("randomSalt");
//        when(PassordUtil.hashMedSalt("passord", "randomSalt")).thenReturn("hashedPassord");
//
//        String resultat = opprettbrukerController.postPaamelding(bruker, ra, null, "passord", request);
//
//        verify(ra).addFlashAttribute("ansatt", bruker);
//        verify(brukerService).lagreBruker(bruker);
//        verify(mocked).loggInnBruker(request, bruker);
//
//        Assertions.assertEquals("redirect:paameldt", resultat);
//
//    }

    /**
     * Tester om getPaamelding(Model) returnerer riktig view "/paamelding".
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void getPaameldingTest() throws Exception {
        Model model = mock(Model.class);
        String resultat = opprettbrukerController.getPaamelding(model);

        Assertions.assertEquals("paamelding", resultat);

        mockMvc.perform(get("/paamelding"))
                .andExpect(status().isOk())
                .andExpect(view().name("paamelding"));
    }

    /**
     * Tester om getPaameldt(Model) returnerer riktig view "/paameldt".
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void getPaameldtTest() throws Exception {
        Model model = mock(Model.class);
        String resultat = opprettbrukerController.getPaameldt(model);

        Assertions.assertEquals("paameldt", resultat);

        mockMvc.perform(get("/paameldt"))
                .andExpect(status().isOk())
                .andExpect(view().name("paameldt"));
    }

}

