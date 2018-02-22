package com.ciastek.javaacademy.shelter.domain.repository;

import com.ciastek.javaacademy.shelter.domain.Animal;

import java.util.List;

public interface AnimalRepository {
    List<Animal> getAllAnimals();
    Animal getAnimalById(int id);
    void removeAnimal(Animal animal);
    void updateAnimal(Animal animal);
}
