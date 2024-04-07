package no.hvl.dat109.prosjekt.service;

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

    /**
     * Metode for å hente alle {@link Prosjekt} i databasen.
     * @return {@link List<Prosjekt>} med prosjektene
     */
    public List<Prosjekt> finnAlle() {
        return prosjektRepo.findAll();
    }

    /**
     * Metode for å finne et prosjekt basert på den angitte id-en.
     * @param id {@link String} med id til prosjektet man vil finne
     * @return {@link Prosjekt} med den angitte id, ellers null
     */
    public Prosjekt finnMedID(String id) {
        //Optional<Prosjekt> projektOptional = prosjektRepo.findById(Integer.parseInt(id));
        //return projektOptional.orElse(null);
        return prosjektRepo.findById(id).orElse(null);
    }

    /**
     * Metode for å lagre prosjektet i databasen.
     * @param prosjekt {@link Prosjekt} som ønskes lagret
     * @return {@link Prosjekt} når lagret
     * @throws org.springframework.dao.DataAccessException hvis det oppstår en feil under lagringsprosessen
     */
    public Prosjekt lagre(Prosjekt prosjekt) {
        return prosjektRepo.save(prosjekt);
    }

}
