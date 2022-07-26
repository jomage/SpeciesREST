package fr.iocean.speciesrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.iocean.speciesrest.enums.Sex;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    @NotEmpty
    private String name;

    @Column(length = 50)
    @NotEmpty
    private String color;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @NotNull
    private Species species;

    @ManyToMany(mappedBy = "animals")
    @JsonIgnore
    Set<Person> persons;

    // Getters / setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
