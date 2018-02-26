package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.AnimalSpecies;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DatabaseAnimalRepository implements AnimalRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public DatabaseAnimalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Animal> getAllAnimals() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Animal", Animal.class).list();
    }

    @Override
    public List<Animal> getAllAnimalsBySpecies(AnimalSpecies animalType) {
        Session session = sessionFactory.getCurrentSession();
        int id = animalType.ordinal();
        String query = String.format("from Animal where species = %d", id);
        return session.createQuery(query, Animal.class).list();
    }

    @Override
    public Animal getAnimalById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Animal.class, id);
    }

    @Override
    public void removeAnimal(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(animal);
    }

    @Override
    public void removeAnimalById(int animalId) {
        removeAnimal(getAnimalById(animalId));
    }

    @Override
    public void updateAnimal(int animalId, Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.update(animal);
    }

    @Override
    public void addAnimal(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(animal);
    }
}
