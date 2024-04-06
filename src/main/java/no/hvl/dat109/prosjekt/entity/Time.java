package no.hvl.dat109.prosjekt.entity;

import jakarta.persistence.*;

@Entity
public class Time {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int antallTimer;

    @ManyToOne
    @JoinColumn(name = "bruker_id")
    private Bruker bruker;

    @ManyToOne
    @JoinColumn(name = "prosjekt_id")
    private Prosjekt prosjekt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
