package no.hvl.dat109.prosjekt.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(schema = "dat109_project", name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EmployeeId;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "job_title")
    private String jobTitle;


}
