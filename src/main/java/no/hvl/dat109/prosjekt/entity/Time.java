package no.hvl.dat109.prosjekt.entity;

import java.util.List;
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

}
