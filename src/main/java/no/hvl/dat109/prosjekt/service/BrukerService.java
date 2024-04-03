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

    //TODO

    public List<Bruker> finnAlle() {
        //TODO
        return null;
    }

    public Bruker finnMedMobil(String mobil) {
        //TODO
        return null;
    }

    public Bruker lagre(Bruker bruker) {
        //TODO
        return null;
    }

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
