package com.ciastek.javaacademy.shelter.service;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.AnimalSpecies;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();
    List<Animal> getAllAnimalsBySpecies(AnimalSpecies animalType);
    Animal getAnimalById(int id);
    void removeAnimal(Animal animal);
    void removeAnimalById(int animalId);
    void updateAnimal(int animalId, Animal animal);
    void addAnimal(Animal animal);
}
