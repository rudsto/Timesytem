package no.hvl.dat109.prosjekt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import no.hvl.dat109.prosjekt.entity.Bruker;


public interface BrukerRepo extends JpaRepository<Bruker, String> {
}
