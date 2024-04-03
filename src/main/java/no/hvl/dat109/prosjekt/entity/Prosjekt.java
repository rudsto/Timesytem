package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "prosjekt", schema = "dat109_prosjekt")

public class Prosjekt {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "prosjekt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Time> timeliste;


    @Column(name = "Prosjektnavn", length = 50)
    @Size(min = 1, max = 50, message = "Prosjektnavnet må være mellom 1-50 bokstaver")
    @NotNull(message = "Projektet må ha navn")
    private String navn;


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
