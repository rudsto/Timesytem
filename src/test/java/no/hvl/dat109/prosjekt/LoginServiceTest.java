package no.hvl.dat109.prosjekt;

import no.hvl.dat109.prosjekt.repo.BrukerRepo;
import no.hvl.dat109.prosjekt.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Testklasse for LoginService
 */
@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private static BrukerRepo brukerRepository;

    @InjectMocks
    private static LoginService loginService;

    /**
     * Tester om loginBruker logger inn bruker.
     */
    @Test
    public void loggInnBrukerTest() {
        String brukernavn = "testBruker";
        String passord = "testPassord";

        when(brukerRepository.authenticate(brukernavn, passord)).thenReturn(true);

        boolean loggetInn = loginService.loggInnBruker(brukernavn, passord);

        assertTrue(loggetInn);
        verify(brukerRepository, times(1)).authenticate(brukernavn, passord);
    }

    /**
     * Tester om loggUtBruker logger ut bruker.
     */
    @Test
    public void loggUtBrukerTest() {
        String brukernavn = "testBruker";

        loginService.loggInnBruker(brukernavn, "passord");

        loginService.loggUtBruker(brukernavn);

        assertFalse(loginService.erBrukerInnlogget(brukernavn));
    }

    /**
     * Tester om erBrukerInnlogget returnerer riktig boolean.
     */
    @Test
    public void erBrukerInnloggetTest() {
        String innloggetBruker = "testBruker1";
        String utloggetBruker = "testBruker2";

        loginService.loggInnBruker(innloggetBruker, "passord");

        assertTrue(loginService.erBrukerInnlogget(innloggetBruker));
        assertFalse(loginService.erBrukerInnlogget(utloggetBruker));
    }
}
