package no.hvl.dat109.prosjekt.service;

import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProsjektService {

    private ProsjektRepo prosjektRepo;
	
    public List<Prosjekt> finnAlle() {
        return prosjektRepo.findAll();
    }

    public Prosjekt finnMedID(Integer id) {
        //TODO

        return null;
    }

    public Prosjekt lagre(Prosjekt prosjekt) {
        //TODO

        return null;
    }

}
