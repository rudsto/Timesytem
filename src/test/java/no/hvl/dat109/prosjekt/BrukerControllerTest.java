package no.hvl.dat109.prosjekt;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.controllers.BrukerController;
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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BrukerController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class BrukerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BrukerService brukerService;
    @MockBean
    private ProsjektService prosjektService;
    @MockBean
    private TimeService timeService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void brukerLoggetInnTest() throws Exception {
        MockHttpSession session = new MockHttpSession();
        HttpServletRequest request = new MockHttpServletRequest();
        Bruker testBruker = new Bruker();
        List<Bruker> brukere = new ArrayList<>();
        brukere.add(testBruker);

        when(brukerService.finnAlleBrukere()).thenReturn(brukere);

        LoginUtil.loggInnBruker(request, testBruker);
        session.setAttribute("bruker", testBruker);

        mockMvc.perform(get("/deltagerliste").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("deltagerliste"))
                .andExpect(model().attribute("ansatte", brukere));


    }

    @Test
    public void brukerIkkeLoggetInnTest() throws Exception {

        mockMvc.perform(get("/deltagerliste"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("login"))
                .andExpect(flash().attributeExists("feilmelding"))
                .andExpect(flash().attribute("feilmelding", "Du må være logget inn for å se deltagerlisten"));

    }
}
