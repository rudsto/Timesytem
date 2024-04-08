package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.service.ProsjektService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


@SpringBootTest(classes = ProsjektController.class)
public class ProsjektControllerTest {

    @Autowired
    private ProsjektController prosjektController;

    @MockBean
    private ProsjektService prosjektService;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    //TODO


}
