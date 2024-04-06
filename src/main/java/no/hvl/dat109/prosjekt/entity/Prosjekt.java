package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "prosjekt", schema = "dat109_prosjekt")
public class Prosjekt {
	
    @Id
    private String id;

    @OneToMany(mappedBy = "prosjekt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Time> timeliste;

    @Column(name = "navn", length = 50)
    @Size(min = 1, max = 50, message = "Prosjektnavnet må være mellom 1-50 bokstaver")
    @NotNull(message = "Projektet må ha navn")
    private String navn;

    public Prosjekt() {

    }

    public Prosjekt(String id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
