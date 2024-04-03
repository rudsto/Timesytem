package no.hvl.dat109.prosjekt.service;

import java.util.List;

import no.hvl.dat109.prosjekt.repo.BrukerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.prosjekt.entity.Bruker;

/**
 * Serviceklasse for behandling av brukerdata.
 */
@Service
public class BrukerService {

    @Autowired
    BrukerRepo brukerRepo;

    /**
     * Finner alle brukere i databasen.
     * @return Liste med brukere
     */
    public List<Bruker> finnAlleBrukere() {
        return brukerRepo.findAll();
    }

    /**
     * Finner én bruker med mobilnummer.
     * @param mobil
     * @return
     */
    public Bruker finnBrukerMedMobil(String mobil) {
        return brukerRepo.findByMobil(mobil);
    }

    /**
     * Lagrer en ny bruker i databasen.
     * @param bruker
     * @return
     */
    public Bruker lagreBruker(Bruker bruker) {
        return brukerRepo.save(bruker);
    }

}
