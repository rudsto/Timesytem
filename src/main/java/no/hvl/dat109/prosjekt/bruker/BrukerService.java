package no.hvl.dat109.prosjekt.bruker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrukerService {
	
	@Autowired
	private BrukerRepository repo;
	
	/**
	 * Henter bruker med gitt mobil fra databasen.
	 * 
	 * @param mobil - primary key til bruker
	 * @return funnet bruker, null om ingen bruker er funnet
	 */
	public Bruker finnMedMobil(String mobil) {
		return repo.findById(mobil).orElse(null); 
	}
	
	/**
	 * Henter alle brukerne fra databasen.
	 * 
	 * @return liste med brukerne, tom hvis ingen er funnet
	 */
	public List<Bruker> finnAlle() {
		return repo.findAll();
	}
	
	/**
	 * Lagrer ny bruker eller oppdaterer bruker med samme mobil i databasen, 
	 * slik at brukeren i databasen samsvarer med bruker gitt som input 
	 * parmeter i metoden.
	 * 
	 * Bruk returnert entitet da det kan være et annet instans av samme bruker.
	 * 
	 * @param bruker - bruker som skal lagres
	 * @return den lagrede brukeren som er persistent med databasen
	 */
	public Bruker lagre(Bruker bruker) {
		return repo.saveAndFlush(bruker);
	}
	
}
