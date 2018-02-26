package com.ciastek.javaacademy.shelter.controller;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "animals")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Animal addAnimal(@RequestBody Animal animal) {
        animalService.addAnimal(animal);
        return animal;
    }

    @RequestMapping(value = "/{animalId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "animalId") int animalId, @RequestBody Animal animal) {
        animalService.updateAnimal(animalId, animal);
    }

    @RequestMapping(value = "/{animalId}", method = RequestMethod.GET)
    public Animal getAnimalById(@PathVariable int animalId) {
        return animalService.getAnimalById(animalId);
    }

    @RequestMapping(value = "/{animalId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeAnimalById(@PathVariable int animalId) {
        animalService.removeAnimalById(animalId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }
}
