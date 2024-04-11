package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.entity.Time;
import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import no.hvl.dat109.prosjekt.repo.TimeRepo;
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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Klasse for å teste funksjonalitet i RedigerTimeController.
 */
@WebMvcTest(controllers = RedigerTimeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class RedigerTimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TimeRepo timeRepo;

    @MockBean
    ProsjektRepo prosjektRepo;

    @MockBean
    private TimeService timeService;

    @MockBean
    private ProsjektService prosjektService;

    @InjectMocks
    private TimeController timeController;
    @Mock
    private Model model;
    @Mock
    private RedirectAttributes ra;
    @InjectMocks
    private RedigerTimeController redigerTimeController;

    private Bruker testBruker = new Bruker();
    private MockHttpSession session = new MockHttpSession();

    /**
     * Tester om getRedigerTimer(HttpSession, Model, RedirectAttributes) returnerer riktig view "/redigertime".
     * @throws Exception dersom det kommer feilmeldeing ved testkjøring.
     */
    @Test
    public void getRedigerTimerTest() throws Exception{

        session.setAttribute("bruker", testBruker);
        String resultat = redigerTimeController.getRedigerTimer(session, model, ra);

        Assertions.assertEquals("redigertime", resultat);

        mockMvc.perform(get("/redigertimer").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("redigertime"));
    }

    /**
     * Tester at postVelgProsjekt(HttpSession, Model, RedirectAttributes, @RequestParam String) returnerer riktig view "/redigertimer".
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postVelgProsjektTest() throws Exception{
        session.setAttribute("bruker", testBruker);
        Optional<Prosjekt> testProsjekt = Optional.of(new Prosjekt());

        when(prosjektService.finnMedID(anyString())).thenReturn(testProsjekt);

        List<Time> testTimer = new ArrayList<>();

        when(timeService.finnBrukerProsjektTimer(any(), any())).thenReturn(testTimer);

        mockMvc.perform(post("/velgprosjekt")
                .param("prosjekt_id", "123")
                .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("redigertimer"));
    }

    /**
     * tester at postRedigerTime(HttpSession, Model, RedirectAttributes,@RequestParam Integer, @RequestParam int)
     * redigerer time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postRedigerTimeTest() throws Exception{
        session.setAttribute("bruker", testBruker);
        Time testTime = new Time();

        when(timeService.finnMedId(anyInt())).thenReturn(testTime);

        mockMvc.perform(post("/redigertime")
                .param("time_id", "123")
                .param("antallTimer", "10")
                .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("redigertimer"));


    }

    /**
     * tester at postSlettTime(HttpSession, Model, RedirectAttributes, @RequestParam Integer)
     * sletter time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postSlettTimeTest() throws Exception{
        session.setAttribute("bruker", testBruker);

        mockMvc.perform(post("/sletttime")
                        .param("time_id", "123")
                        .session(session))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("redigertimer"));

        verify(timeService).slettTime(123);


    }
}
