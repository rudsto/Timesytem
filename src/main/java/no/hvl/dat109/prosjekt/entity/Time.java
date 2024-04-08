package no.hvl.dat109.prosjekt.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "timereg", schema = "dat109_prosjekt")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer time_id;
    @Min(value = 1)
    @Max(value = 99)
    @NotNull(message = "Tast inn timer jobbet")
    private int antallTimer;

    @ManyToOne
    @JoinColumn(name = "mobil")
    private Bruker bruker;

    @ManyToOne
    @JoinColumn(name = "prosjekt_id")
    private Prosjekt prosjekt;

    public Time() {
    }

    public Time(int antallTimer, Bruker bruker, Prosjekt prosjekt) {
        this.antallTimer = antallTimer;
        this.bruker = bruker;
        this.prosjekt = prosjekt;
    }

    public Integer getTime_id() {
        return time_id;
    }

    public int getAntallTimer() {
        return antallTimer;
    }

    public void setAntallTimer(int antallTimer) {
        this.antallTimer = antallTimer;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public Prosjekt getProsjekt() {
        return prosjekt;
    }

    public void setProsjekt(Prosjekt prosjekt) {
        this.prosjekt = prosjekt;
    }
}
