package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "prosjekt", schema = "dat109_prosjekt")
public class Prosjekt {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String navn;

    @OneToMany(mappedBy = "prosjekt")
    private List<Time> timeliste;

}
