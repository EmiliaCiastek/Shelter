package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration("/test-DispatcherServlet-context.xml")
@ExtendWith(SpringExtension.class)
class DatabaseAnimalRepositoryTest {

    @Autowired
    private AnimalRepository repository;

    @Test
    public void should_return_empty_list_when_db_is_empty() {
        List<Animal> animals = repository.getAllAnimals();

        assertThat(animals).isEmpty();
    }
}