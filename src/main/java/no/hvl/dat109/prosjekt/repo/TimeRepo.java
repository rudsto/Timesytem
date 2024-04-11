package no.hvl.dat109.prosjekt.repo;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import org.springframework.data.jpa.repository.JpaRepository;
import no.hvl.dat109.prosjekt.entity.Time;

import java.util.List;

public interface TimeRepo extends JpaRepository<Time, Integer> {
}
