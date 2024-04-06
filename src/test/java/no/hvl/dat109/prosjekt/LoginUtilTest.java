package no.hvl.dat109.prosjekt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.Utils.LoginUtil;
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
public class LoginUtilTest {


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

        LoginUtil.loggInnBruker(request, testBruker);
        session = request.getSession();
        assertNotNull(session);
        assertTrue(LoginUtil.erBrukerInnlogget(session));
        assertEquals(LoginUtil.MAX_INACTIVE_INTERVAL, session.getMaxInactiveInterval());
        assertEquals(testBruker, session.getAttribute("bruker"));

    }

    /**
     * Tester om loggUtBruker logger ut bruker.
     */
    @Test
    public void loggUtBrukerTest() {

        LoginUtil.loggInnBruker(request, testBruker);
        session = request.getSession();

        assertNotNull(session.getAttribute("bruker"));
        assertTrue(LoginUtil.erBrukerInnlogget(session));

        LoginUtil.loggUtBruker(session);

        assertNull(request.getSession(false));

    }

    /**
     * Tester om erBrukerInnlogget returnerer riktig boolean.
     */
    @Test
    public void erBrukerInnloggetTest() {

        // bruker som er logget inn
        LoginUtil.loggInnBruker(request, testBruker);
        session = request.getSession();
        assertTrue(LoginUtil.erBrukerInnlogget(session));

        // bruker som ikke er logget inn
        HttpSession brukerIkkeLoggetInn = new MockHttpSession();
        assertFalse(LoginUtil.erBrukerInnlogget(brukerIkkeLoggetInn));
    }
}
