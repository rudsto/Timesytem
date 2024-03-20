package no.hvl.dat109.prosjekt.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(schema = "dat109_project", name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "profession")
    private String profession;

    @Column(name = "phone")
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return Objects.equals(employeeId, employee.employeeId);
    }

    @Override
    public int hashCode() {
        return employeeId != null ? employeeId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", profession='" + profession + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String jobTitle) {
        this.profession = jobTitle;
    }
}
