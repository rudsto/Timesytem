package no.hvl.dat109.prosjekt;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.entity.Time;
import no.hvl.dat109.prosjekt.repo.TimeRepo;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TimeServiceTest {

	@Mock
	TimeRepo timeRepo;

	@InjectMocks
	TimeService timeService;


	@Test
	public void finnAlleTimerTest(){

		Time time1 = new Time();
		Time time2 = new Time();
		List<Time> timer = Arrays.asList(time1, time2);

		when(timeRepo.findAll()).thenReturn(timer);

		List<Time> resultat = timeService.finnAlleTimer();

		assertEquals(timer, resultat);
		assertEquals(2, resultat.size());
	}

	@Test
	public void finnBrukerTimerTest() {

		Bruker bruker = new Bruker();
		Time time1 = new Time();
		Time time2 = new Time();
		time1.setBruker(bruker);
		time2.setBruker(bruker);
		List<Time> timer = Arrays.asList(time1, time2);

		when(timeRepo.findAll()).thenReturn(timer);

		List<Time> resultat = timeService.finnBrukerTimer(bruker);

		assertEquals(bruker, time1.getBruker());
		assertEquals(bruker, time2.getBruker());
		assertEquals(2, resultat.size());
	}

	@Test
	public void finnProsjektTimerTest() {

		Prosjekt prosjekt = new Prosjekt();
		Time time1 = new Time();
		Time time2 = new Time();
		time1.setProsjekt(prosjekt);
		time2.setProsjekt(prosjekt);
		List<Time> timer = Arrays.asList(time1, time2);

		when(timeRepo.findAll()).thenReturn(timer);

		List<Time> resultat = timeService.finnProsjektTimer(prosjekt);

		assertEquals(prosjekt, time1.getProsjekt());
		assertEquals(prosjekt, time2.getProsjekt());
		assertEquals(2, resultat.size());
	}

	@Test
	public void finnBrukerProsjektTimerTest() {

		Bruker bruker = new Bruker();
		Prosjekt prosjekt = new Prosjekt();
		Time time1 = new Time();
		Time time2 = new Time();
		time1.setBruker(bruker);
		time2.setBruker(bruker);
		time1.setProsjekt(prosjekt);
		time2.setProsjekt(prosjekt);
		List<Time> timer = Arrays.asList(time1, time2);

		when(timeRepo.findAll()).thenReturn(timer);

		List<Time> resultat = timeService.finnBrukerProsjektTimer(bruker, prosjekt);

		assertEquals(bruker, time1.getBruker());
		assertEquals(bruker, time2.getBruker());
		assertEquals(prosjekt, time1.getProsjekt());
		assertEquals(prosjekt, time2.getProsjekt());
		assertEquals(2, resultat.size());
	}

	@Test
	public void lagreTimeTest() {

		Time time = new Time();
		time.setAntallTimer(8);

		when(timeService.lagreTime(time)).thenReturn(time);

		Time resultat = timeService.lagreTime(time);
		assertEquals(time, resultat);
		assertEquals(8, resultat.getAntallTimer());
	}

}
