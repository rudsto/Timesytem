package no.hvl.dat109.prosjekt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class ProsjektServiceTest {

	private ProsjektService prosjektService;
	private ProsjektRepo prosjektRepo;

	@BeforeEach
	public void setup() {
		prosjektRepo = mock(ProsjektRepo.class);
		prosjektService = new ProsjektService(prosjektRepo);
	}

	@Test
	public void finnAlleTest() {
		List<Prosjekt> prosjekter = new ArrayList<>();
		Prosjekt prosjekt1 = new Prosjekt();
		prosjekt1.setNavn("1100 Adm");
		prosjekter.add(prosjekt1);

		Prosjekt prosjekt2 = new Prosjekt();
		prosjekt2.setNavn("1200 Salg");
		prosjekter.add(prosjekt2);

		ProsjektService mockProsjektService = mock(ProsjektService.class);
		when(mockProsjektService.finnAlle()).thenReturn(prosjekter);

		List<Prosjekt> testResultatet = mockProsjektService.finnAlle();
		assertEquals(prosjekter, testResultatet);
		assertEquals(2, testResultatet.size());
	}

	@Test
	public void finnMedIdTest() {
		Prosjekt prosjekt = new Prosjekt();
		prosjekt.setNavn("1400 HR");
		System.out.println(prosjekt.getId());

		when(prosjektRepo.findById(1)).thenReturn(Optional.of(prosjekt));

		Prosjekt testResultat = prosjektService.finnMedID(1);
		assertEquals(prosjekt, testResultat);
		assertEquals(1, testResultat.getId());
		assertEquals("1400 HR", testResultat.getNavn());
	}

}
