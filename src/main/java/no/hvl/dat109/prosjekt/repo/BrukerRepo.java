package no.hvl.dat109.prosjekt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.hvl.dat109.prosjekt.entity.Bruker;

public interface BrukerRepo extends JpaRepository<Bruker, Integer> {
	
	Bruker findByMobil(String mobil);

    Object authenticate(String brukernavn, String passord);
}
