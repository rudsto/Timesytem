package no.hvl.dat109.prosjekt.service;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.entity.Time;
import no.hvl.dat109.prosjekt.repo.TimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviceklasse for behandling av timer i timeføringsystemet.
 */
@Service
public class TimeService {

    @Autowired
    TimeRepo timeRepo;

    /**
     * Finner alle registrerte timer.
     * @return liste med alle timer
     */
	public List<Time> finnAlleTimer(){

        return timeRepo.findAll();

    }

    /**
     * Finner alle timer registrert på en bruker..
     * @param bruker en bruker
     * @return liste med timer for en bruker
     */
    public List<Time> finnBrukerTimer(Bruker bruker) {

    	List<Time> alleTimer = finnAlleTimer();

        return alleTimer.stream()
                .filter(time -> time.getBruker().equals(bruker))
                .collect(Collectors.toList());

    }

    /**
     * Finner alle timer registrert på et prosjekt.
     * @param prosjekt et prosjekt
     * @return list med timer på et prosjekt
     */
    public List<Time> finnProsjektTimer(Prosjekt prosjekt) {

    	List<Time> alleTimer = finnAlleTimer();

        return alleTimer.stream()
                .filter(time -> time.getProsjekt().equals(prosjekt))
                .collect(Collectors.toList());
    }

    /**
     * Finner alle timer registrert på en bruker for et bestemt prosjekt.
     * @param bruker en bruker
     * @param prosjekt et prosjekt
     * @return liste med timer til en bruker på et bestemt prosjekt
     */
    public List<Time> finnBrukerProsjektTimer(Bruker bruker, Prosjekt prosjekt) {

    	List<Time> alleTimer = finnAlleTimer();

        return alleTimer.stream()
                .filter(time -> time.getBruker().equals(bruker))
                .filter(time -> time.getProsjekt().equals(prosjekt))
                .collect(Collectors.toList());

    }

    /**
     * Lagrer timer.
     * @param time et time objekt
     * @return timer som blir lagret
     */
    public Time lagreTime(Time time) {
        return timeRepo.save(time);
    }

    public void slettTime(Integer time_id) {
        timeRepo.deleteById(time_id);
    }

    public Time finnMedId(Integer time_id) {
        return timeRepo.findById(time_id).get();
    }
}
