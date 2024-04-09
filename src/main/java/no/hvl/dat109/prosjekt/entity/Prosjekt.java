package no.hvl.dat109.prosjekt.entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Klases for entieten prosjekt. Inneholder variabler og get/set metoder.
 */
@Entity
@Table(name = "prosjekt", schema = "dat109_prosjekt")
public class Prosjekt {

    @Id
    @Column(name = "prosjekt_id", length = 6)
    @Size(min = 6, max = 6, message = "Prosjektid må være 6 siffer")
    @NotNull(message = "Prosjektid er obligatorisk")
    @Pattern(regexp = "[0-9]{6}", message = "Prosjektid må være 6 siffer")
    private String prosjekt_id;

    @OneToMany(mappedBy = "prosjekt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Time> timeliste;

    @Column(name = "navn", length = 64)
    @Size(min = 1, max = 64, message = "Prosjektnavnet må være mellom 1-64 bokstaver")
    @NotNull(message = "Projektet må ha navn")
    private String navn;

    public String getProsjekt_id() {
        return prosjekt_id;
    }

    public void setProsjekt_id(String id) {
        this.prosjekt_id = id;
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
