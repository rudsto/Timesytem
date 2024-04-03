package no.hvl.dat109.prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.prosjekt.service.BrukerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.prosjekt.entity.Bruker;


public class BrukerServiceTest {

    private BrukerService brukerService;

    @BeforeEach
    public void setup() {
        brukerService = new BrukerService();
    }

    @Test
    public void testFinnAlle() {
        List<Bruker> brukere = new ArrayList<>();
        Bruker bruker1 = new Bruker();
        bruker1.setMobil("12345678");
        bruker1.setFornavn("Ola");
        bruker1.setEtternavn("Nordmann");
        brukere.add(bruker1);

        Bruker bruker2 = new Bruker();
        bruker2.setMobil("43211234");
        bruker2.setFornavn("Jens");
        bruker2.setEtternavn("Jensen");
        brukere.add(bruker2);

        BrukerService mockBrukerService = mock(BrukerService.class);
        when(mockBrukerService.finnAlle()).thenReturn(brukere);

        List<Bruker> resultat = mockBrukerService.finnAlle();
        assertEquals(brukere, resultat);
        assertEquals(2, resultat.size());
    }

    @Test
    public void testFinnMedMobil() {
        Bruker bruker = new Bruker();
        bruker.setMobil("12345678");
        bruker.setFornavn("Ola");
        bruker.setEtternavn("Nordmann");

        BrukerService mockBrukerService = mock(BrukerService.class);
        when(mockBrukerService.finnMedMobil("12345678")).thenReturn(bruker);

        Bruker resultat = mockBrukerService.finnMedMobil("12345678");
        assertEquals(bruker, resultat);
        assertEquals("12345678", resultat.getMobil());
    }

    @Test
    public void testLagre() {
        Bruker bruker = new Bruker();
        bruker.setMobil("12345678");
        bruker.setFornavn("Ola");
        bruker.setEtternavn("Nordmann");

        BrukerService mockBrukerService = mock(BrukerService.class);
        when(mockBrukerService.lagre(bruker)).thenReturn(bruker);

        Bruker resultat = mockBrukerService.lagre(bruker);
        assertEquals(bruker, resultat);
        assertEquals("12345678", resultat.getMobil());
    }
}
