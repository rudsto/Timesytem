package no.hvl.dat109.prosjekt.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(schema = "dat109_prosjekt", name = "")
public class Bruker {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String stilling;

    private Project projects;

}
