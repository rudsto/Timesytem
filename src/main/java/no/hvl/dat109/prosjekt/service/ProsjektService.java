package no.hvl.dat109.prosjekt.service;

import javax.persistence.Id;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProsjektService {

    @Autowired
    private ProsjektRepo prosjektRepo;

    public List<Prosjekt> finnAlle() {
        return prosjektRepo.findAll();
    }

    public Prosjekt finnMedID(String id) {
        Optional<Prosjekt> projektOptional = prosjektRepo.findById(Integer.parseInt(id));

        return projektOptional.orElse(null);
    }

    public Prosjekt lagre(Prosjekt prosjekt) {
        return prosjektRepo.save(prosjekt);
    }

}
