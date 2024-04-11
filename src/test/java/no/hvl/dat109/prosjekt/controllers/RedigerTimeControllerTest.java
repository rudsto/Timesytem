package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.entity.Bruker;
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

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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


    /**
     * Tester om getRedigerTimer(HttpSession, Model, RedirectAttributes) returnerer riktig view "/redigertime".
     * @throws Exception dersom det kommer feilmeldeing ved testkjøring.
     */
    @Test
    public void getRedigerTimerTest() throws Exception{

        Bruker testBruker = new Bruker();
        MockHttpSession session = new MockHttpSession();
        session.setAttribute("bruker", testBruker);
        String resultat = redigerTimeController.getRedigerTimer(session, model, ra);

        Assertions.assertEquals("redigertime", resultat);

        mockMvc.perform(get("/redigertimer").session(session))
                .andExpect(status().isOk())
                .andExpect(view().name("redigertime"));
    }

    /**
     * Tester at postVelgProsjekt(HttpSession, Model, RedirectAttributes) returnerer riktig view "/redigertimer".
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postVelgProsjektTest() throws Exception{
        fail("Test ikke implementert");

    }

    /**
     * tester at postRedigerTime(HttpSession, Model, RedirectAttributes,@RequestParam Integer, @RequestParam int)
     * redigerer time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postRedigerTimeTest() throws Exception{
        fail("Test ikke implementert");

    }

    /**
     * tester at postSlettTime(HttpSession, Model, RedirectAttributes, @RequestParam Integer)
     * sletter time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postSlettTimeTest() throws Exception{
        fail("test ikke implementert");
    }
}
