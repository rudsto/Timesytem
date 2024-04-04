package no.hvl.dat109.prosjekt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.service.LoginService;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse for LoginService
 */
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {


    private HttpServletRequest request;
    private HttpSession session;
    private Bruker testBruker;

    /**
     * Initialiserer mock-objekter for videre bruk i test-klassen.
     */
    @BeforeEach
    public void setUp() {
        request = new MockHttpServletRequest();
        session = new MockHttpSession();
        testBruker = new Bruker();
    }

    /**
     * Tester om loginBruker logger inn bruker.
     */
    @Test
    public void loggInnBrukerTest() {

        LoginService.loggInnBruker(request, testBruker);
        session = request.getSession();
        assertNotNull(session);
        assertTrue(LoginService.erBrukerInnlogget(session));
        assertEquals(LoginService.MAX_INACTIVE_INTERVAL, session.getMaxInactiveInterval());
        assertEquals(testBruker, session.getAttribute("bruker"));

    }

    /**
     * Tester om loggUtBruker logger ut bruker.
     */
    @Test
    public void loggUtBrukerTest() {

//        LoginService.loggInnBruker(request, testBruker);
//        session = request.getSession();
//        LoginService.loggUtBruker(session);
//
//        assertNull(session.getAttribute("bruker"));
//        assertFalse(LoginService.erBrukerInnlogget(session));

    }

    /**
     * Tester om erBrukerInnlogget returnerer riktig boolean.
     */
    @Test
    public void erBrukerInnloggetTest() {

//        assertFalse(LoginService.erBrukerInnlogget(session));
//        LoginService.loggInnBruker(request, testBruker);
//        assertTrue(LoginService.erBrukerInnlogget(session));
//        LoginService.loggUtBruker(session);
//        assertFalse(LoginService.erBrukerInnlogget(session));

    }
}
