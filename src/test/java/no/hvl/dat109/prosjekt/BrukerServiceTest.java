package no.hvl.dat109.prosjekt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import no.hvl.dat109.prosjekt.repo.BrukerRepo;
import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.entity.Bruker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BrukerServiceTest {

    @Autowired
    private BrukerService brukerService;

    @MockBean
    private BrukerRepo brukerRepo;

	/**
	 * Test av metoden finnAlle().Skal teste at metoden returner en liste av alle brukere.
	 * Legger til to brukere og tester at listen stemmer.
	 */
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

        when(brukerRepo.findAll()).thenReturn(brukere);

        List<Bruker> resultat = brukerService.finnAlleBrukere();
        assertEquals(brukere, resultat);
        assertEquals(2, resultat.size());
    }

	/**
	 * Test av metoden finnMedMobil(). Skal teste at metoden returner brukeren med telefonnummeret.
	 * Legger til en bruker og forsøker å hente den.
	 */
    @Test
    public void testFinnMedMobil() {
        Bruker bruker = new Bruker();
        bruker.setMobil("12345678");
        bruker.setFornavn("Ola");
        bruker.setEtternavn("Nordmann");

        when(brukerRepo.findById("12345678")).thenReturn(Optional.of(bruker));

        Bruker resultat = brukerService.finnBrukerMedMobil("12345678");
        assertEquals(bruker, resultat);
        assertEquals("12345678", resultat.getMobil());
    }

    /**
     * Test for metoden testLagre(). Skal teste at metoden lagrer brukeren og returnerer den.
     * Legger til en bruker og tester om den er lagret.
     */
    @Test
    public void testLagre() {
        Bruker bruker = new Bruker();
        bruker.setMobil("12345678");
        bruker.setFornavn("Ola");
        bruker.setEtternavn("Nordmann");

        when(brukerRepo.save(bruker)).thenReturn(bruker);
        Bruker resultat = brukerService.lagreBruker(bruker);

        assertEquals(bruker, resultat);
        assertEquals("12345678", resultat.getMobil());
    }
}
