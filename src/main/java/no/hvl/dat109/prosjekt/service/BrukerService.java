package no.hvl.dat109.prosjekt.service;

import java.util.List;

import no.hvl.dat109.prosjekt.repo.BrukerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import no.hvl.dat109.prosjekt.entity.Bruker;

@Service
public class BrukerService {

    @Autowired
    BrukerRepo brukerRepo;

    public List<Bruker> finnAlleBrukere() {
        return brukerRepo.findAll();
    }

    public Bruker finnBrukerMedMobil(String mobil) {
        return brukerRepo.findByMobil(mobil);
    }

    public Bruker lagreBruker(Bruker bruker) {
        return brukerRepo.save(bruker);
    }

}
