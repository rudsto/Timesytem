package no.hvl.dat109.prosjekt.controllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TimeService timeService;

    @Mock
    private ProsjektService prosjektService;

    @InjectMocks
    private TimeController timeController;

    @Test
    public void testGetRegistrerTime() throws Exception {
        mockMvc.perform(get("/registrertime").session(new MockHttpSession()))
                .andExpect(status().isOk())
                .andExpect(view().name("registrertime"))
                .andExpect(model().attributeExists("prosjekter"));
    }

    @Test
    public void testRegistrerTimer() throws Exception {
        Prosjekt mockProsjekt = new Prosjekt();
        mockProsjekt.setProsjekt_id("123987");
        mockProsjekt.setNavn("Test Prosjekt");

        when(prosjektService.finnMedID("123987")).thenReturn(mockProsjekt);

        mockMvc.perform(post("/registrertime").param("prosjekt_id", "123987").param("antallTimer", "5").session(new MockHttpSession()))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("registrertime"))
                .andExpect(flash().attributeExists("time"))
                .andExpect(flash().attributeExists("prosjekt"));

        verify(timeService, times(1)).lagreTime(any());
    }
}
