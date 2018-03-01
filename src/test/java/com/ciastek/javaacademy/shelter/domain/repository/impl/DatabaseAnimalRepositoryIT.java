package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.AnimalSpecies;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration("/test-DispatcherServlet-context.xml")
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DatabaseAnimalRepositoryIT {
    @Autowired
    private AnimalRepository repository;

    @Test
    public void should_return_empty_list_when_db_is_empty() {
        List<Animal> animals = repository.getAllAnimals();

        assertThat(animals).isEmpty();
    }

    @Test
    public void should_add_animal_to_db(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        repository.addAnimal(animal);
        List<Animal> animals = repository.getAllAnimals();

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(animals.size()).isEqualTo(1);
        Animal actualAnimal = animals.get(0);
        soft.assertThat(actualAnimal.getName()).isEqualTo(animal.getName());
        soft.assertThat(actualAnimal.getAge()).isEqualTo(animal.getAge());
        soft.assertThat(actualAnimal.getDescription()).isEqualTo(animal.getDescription());
        soft.assertThat(actualAnimal.getId()).isEqualTo(animal.getId());
        soft.assertAll();
    }

    @Test
    public void should_get_animal_by_id(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        repository.addAnimal(animal);
        Animal secondAnimal = new Animal("Koteł", "He's a lonely cat, he really needs a friend!", 5, AnimalSpecies.CAT);
        repository.addAnimal(secondAnimal);

        int id = secondAnimal.getId();
        Animal actualAnimal = repository.getAnimalById(id);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(actualAnimal.getName()).isEqualTo(secondAnimal.getName());
        soft.assertThat(actualAnimal.getAge()).isEqualTo(secondAnimal.getAge());
        soft.assertThat(actualAnimal.getDescription()).isEqualTo(secondAnimal.getDescription());
        soft.assertThat(actualAnimal.getSpecies()).isEqualTo(secondAnimal.getSpecies());
        soft.assertThat(actualAnimal.getId()).isEqualTo(secondAnimal.getId());
        soft.assertAll();
    }

    @Test
    public void should_update_animal_in_db(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        repository.addAnimal(animal);

        animal.setAge(12);
        animal.setDescription("Very friendly dog but he's getting old.");
        repository.updateAnimal(1, animal);
        Animal actualAnimal = repository.getAnimalById(1);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(actualAnimal.getName()).isEqualTo(animal.getName());
        soft.assertThat(actualAnimal.getAge()).isEqualTo(animal.getAge());
        soft.assertThat(actualAnimal.getDescription()).isEqualTo(animal.getDescription());
        soft.assertThat(actualAnimal.getId()).isEqualTo(animal.getId());
        soft.assertAll();
    }

    @Test
    public void should_remove_animal_from_db(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        repository.addAnimal(animal);
        repository.removeAnimal(animal);

        List<Animal> animals = repository.getAllAnimals();
        assertThat(animals.size()).isEqualTo(0);
    }

    @Test
    public void should_get_all_animals_by_species(){
        Animal animal = new Animal("Reksio", "Very friendly dog.", 10, AnimalSpecies.DOG);
        repository.addAnimal(animal);
        Animal firstCat = new Animal("Koteł", "He's a lonely cat, he really needs a friend!", 5, AnimalSpecies.CAT);
        Animal secondCat = new Animal("Turboraptor3000", "He's a small, cute kitten.", 1, AnimalSpecies.CAT);
        repository.addAnimal(firstCat);
        repository.addAnimal(secondCat);

        List<Animal> allAnimals = repository.getAllAnimals();
        List<Animal> cats = repository.getAllAnimalsBySpecies(AnimalSpecies.CAT);

        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(allAnimals.size()).isEqualTo(3);
        soft.assertThat(cats.size()).isEqualTo(2);
        soft.assertThat(cats.get(0).getName()).isEqualTo(firstCat.getName());
        soft.assertThat(cats.get(1).getName()).isEqualTo(secondCat.getName());
        soft.assertAll();
    }
}