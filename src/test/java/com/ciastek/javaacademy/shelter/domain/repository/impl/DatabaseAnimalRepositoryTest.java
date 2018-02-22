package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DatabaseAnimalRepositoryTest {
    private AnimalRepository repository;

    @BeforeEach
    public void setUp(){
        repository = new DatabaseAnimalRepository();
    }

    @Test
    public void should_return_empty_list_when_db_is_empty(){
        List<Animal> animals = repository.getAllAnimals();

        assertThat(animals).isEmpty();
    }
}