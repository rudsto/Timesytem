package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "prosjekt", schema = "dat109_prosjekt")
public class Prosjekt {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Prosjektnavn er obligatorisk")
    private String navn;

    @OneToMany(mappedBy = "prosjekt")
    private List<Time> timeliste;

    public Integer getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public List<Time> getTimeliste() {
        return timeliste;
    }

}
