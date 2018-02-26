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
    public void should_invoke_addAnimal_on_repository(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        animalService.addAnimal(animal);

        verify(animalRepository, times(1)).addAnimal(animal);
    }
}