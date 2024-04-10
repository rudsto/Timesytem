package no.hvl.dat109.prosjekt.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hvl.dat109.prosjekt.repo.TimeRepo;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
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
    @Mock
    private TimeRepo timeRepo;
    @InjectMocks
    private RedigerTimeController redigerTimeController;
    @MockBean
    private TimeService timeService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Tester om getRedigerTime() returnerer riktig view "/redigertime".
     * @throws Exception dersom det kommer feilmeldeing ved testkjøring.
     */
    @Test
    public void getRedigerTimeTest() throws Exception{
        Model model = mock(Model.class);
//        String resultat = redigerTimeController.getRedigerTime(model);

//        Assertions.assertEquals("redigertime", resultat);

        mockMvc.perform(get("/redigertime"))
                .andExpect(status().isOk())
                .andExpect(view().name("redigertime"));
    }

    /**
     * tester at postRedigerTime() redigerer time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postRedigerTimeTest() throws Exception{
        fail("Test ikke implementert");

    }

    /**
     * tester at postSlettTime() sletter time og redirect til riktig view.
     * @throws Exception dersom det kommer feilmelding ved testkjøring
     */
    @Test
    public void postSlettTimeTest() throws Exception{
        fail("test ikke implementert");
    }
}
