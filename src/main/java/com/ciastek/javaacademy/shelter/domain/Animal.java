package com.ciastek.javaacademy.shelter.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(columnDefinition = "longtext")
    private String description;

    private String name;
    private AnimalSpecies species;
    private int age;

    public Animal() {
    }

    public Animal(String name, String description, int age, AnimalSpecies species) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public int getAge() {
        return age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalSpecies getSpecies() {
        return species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(description, animal.description) &&
                Objects.equals(name, animal.name) &&
                species == animal.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, species, age);
    }
}
