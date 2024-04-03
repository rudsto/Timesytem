package no.hvl.dat109.prosjekt.service;

import jakarta.persistence.Id;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProsjektService {

    private ProsjektRepo prosjektRepo;

    @Autowired
    public ProsjektService(ProsjektRepo prosjektRepo) {
        this.prosjektRepo = prosjektRepo;
    }
	
    public List<Prosjekt> finnAlle() {
        return prosjektRepo.findAll();
    }

    public Prosjekt finnMedID(Integer id) {
        Optional<Prosjekt> projektOptional = prosjektRepo.findById(id);

        return projektOptional.orElse(null);
    }

    public Prosjekt lagre(Prosjekt prosjekt) {


        return prosjektRepo.save(prosjekt);
    }

}
