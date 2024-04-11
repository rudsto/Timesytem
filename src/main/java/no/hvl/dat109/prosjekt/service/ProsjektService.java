package no.hvl.dat109.prosjekt.service;

import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.repo.ProsjektRepo;
import no.hvl.dat109.prosjekt.repo.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProsjektService {

    @Autowired
    private ProsjektRepo prosjektRepo;

    @Autowired
    private TimeRepo timeRepo;

    /**
     * Metode for å hente alle {@link Prosjekt} i databasen.
     *
     * @return {@link List<Prosjekt>} med prosjektene
     */
    public List<Prosjekt> finnAlle() {
        return prosjektRepo.findAll();
    }

    /**
     * Metode for å finne et prosjekt basert på den angitte id-en.
     *
     * @param id {@link String} med id til prosjektet man vil finne
     * @return {@link Optional<Prosjekt>} med et treff eller "no-result"
     */
    public Optional<Prosjekt> finnMedID(String id) {
        return prosjektRepo.findById(id);
        //return prosjektRepo.findById(id).orElse(null);
    }

    /**
     * Metode for å lagre prosjektet i databasen.
     *
     * @param prosjekt {@link Prosjekt} som ønskes lagret
     * @return {@link Prosjekt} når lagret
     * @throws org.springframework.dao.DataAccessException hvis det oppstår en feil under lagringsprosessen
     */
    public Prosjekt lagre(Prosjekt prosjekt) {
        return prosjektRepo.save(prosjekt);
    }

    /**
     * Metode for å slette prosjekt i databasen
     * @param prosjekt {@link Prosjekt} objektet som skal slettes
     */
    public void slettProsjekt(Prosjekt prosjekt) {
        prosjektRepo.delete(prosjekt);
    }

    /**
     * Redigerer prosjektet med den angitte gamle prosjekt-ID-en ved å oppdatere prosjektnavnet.
     *
     * @param gammelProsjektId Den gamle prosjekt-ID-en som skal redigeres
     * @param nyttProsjektnavn Det nye navnet som prosjektet skal oppdateres med
     * @throws IllegalArgumentException hvis prosjektet ikke finnes basert på den angitte gamle prosjekt-ID-en
     */
    public void redigerProsjekt(String gammelProsjektId, String nyttProsjektnavn) {
        Optional<Prosjekt> maybeProsjekt = prosjektRepo.findById(gammelProsjektId);

        // Sjekker om prosjektet eksisterer
        if (maybeProsjekt.isEmpty()) {
            throw new IllegalArgumentException("Prosjektet finnes ikke");
        }

        // Henter prosjektet
        Prosjekt prosjekt = maybeProsjekt.get();

        // Oppdaterer prosjektnavnet
        prosjekt.setNavn(nyttProsjektnavn);

        // Lagrer endringene i databasen
        prosjektRepo.save(prosjekt);
    }

}






