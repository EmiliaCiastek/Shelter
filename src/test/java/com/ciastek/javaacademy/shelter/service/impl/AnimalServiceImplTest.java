package com.ciastek.javaacademy.shelter.service.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.AnimalSpecies;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import com.ciastek.javaacademy.shelter.service.AnimalService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AnimalServiceImplTest {
    private AnimalRepository animalRepository = mock(AnimalRepository.class); //TODO: change to Fake implementation
    private AnimalService animalService = new AnimalServiceImpl(animalRepository);

    @Test
    void should_invoke_addAnimal_on_repository(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        animalService.addAnimal(animal);

        verify(animalRepository, times(1)).addAnimal(animal);
    }

    @Test
    void should_invoke_update_on_repository(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        int animalId = 1;
        animalService.updateAnimal(animalId, animal);

        verify(animalRepository, times(1)).updateAnimal(animalId, animal);
    }

    @Test
    void should_invoke_getById_on_repository(){
        int animalId = 1;
        animalService.getAnimalById(animalId);

        verify(animalRepository, times(1)).getAnimalById(animalId);
    }

    @Test
    void should_invoke_removeAnimal_on_repository(){
        int animalId = 3;
        animalService.removeAnimalById(animalId);

        verify(animalRepository, times(1)).removeAnimalById(animalId);
    }

    @Test
    void should_invoke_getAllAnimals_on_repository(){
        animalService.getAllAnimals();

        verify(animalRepository, times(1)).getAllAnimals();
    }

    @Test
    void should_invoke_getAllAnimalsBySpecies_on_repository(){
        AnimalSpecies species = AnimalSpecies.CHINCHILLA;
        animalService.getAllAnimalsBySpecies(species);

        verify(animalRepository, times(1)).getAllAnimalsBySpecies(species);
    }
}