package com.spitz.netfinder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person", schema = "netfinder")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

    @Size(max = 45)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Size(max = 45)
    @Column(name = "telephone", length = 45)
    private String telephone;

    @OneToMany(mappedBy = "uidPersonReported")
    private Set<Net> reported_nets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "uidPersonRecover")
    private Set<Net> recover_nets = new LinkedHashSet<>();

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Net> getReported_nets() {
        return reported_nets;
    }

    public void setReported_nets(Set<Net> reported_nets) {
        this.reported_nets = reported_nets;
    }

    public Set<Net> getRecover_nets() {
        return recover_nets;
    }

    public void setRecover_nets(Set<Net> recover_nets) {
        this.recover_nets = recover_nets;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getFirstname(), person.getFirstname()) && Objects.equals(getLastname(), person.getLastname()) && Objects.equals(getTelephone(), person.getTelephone()) && Objects.equals(getReported_nets(), person.getReported_nets()) && Objects.equals(getRecover_nets(), person.getRecover_nets());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getLastname(), getTelephone(), getReported_nets(), getRecover_nets());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", reported_nets=" + reported_nets +
                ", recover_nets=" + recover_nets +
                '}';
    }
}