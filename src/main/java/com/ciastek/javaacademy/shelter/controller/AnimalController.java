package com.ciastek.javaacademy.shelter.controller;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "animals")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Animal addAnimal(@RequestBody Animal animal){
        animalService.addAnimal(animal);
        return animal;
    }
}
