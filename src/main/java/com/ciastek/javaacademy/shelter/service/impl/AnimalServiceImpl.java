package com.ciastek.javaacademy.shelter.service.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.AnimalSpecies;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import com.ciastek.javaacademy.shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.getAllAnimals();
    }

    @Override
    public List<Animal> getAllAnimalsBySpecies(AnimalSpecies animalType) {
        return animalRepository.getAllAnimalsBySpecies(animalType);
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalRepository.getAnimalById(id);
    }

    @Override
    public void removeAnimal(Animal animal) {
        throw new NotImplementedException();
    }

    @Override
    public void removeAnimalById(int animalId) {
        animalRepository.removeAnimalById(animalId);
    }

    @Override
    public void updateAnimal(int animalId, Animal animal) {
        animalRepository.updateAnimal(animalId, animal);
    }

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
    }
}
