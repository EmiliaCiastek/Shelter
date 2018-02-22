package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
//@Transactional
public class DatabaseAnimalRepository implements AnimalRepository {
    //@Autowired
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<Animal> getAllAnimals() {
        Session session = sessionFactory.openSession();
        List<Animal> animals = session.createQuery("from Animal", Animal.class).list();
        session.close();

        return animals;
    }

    @Override
    public Animal getAnimalById(int id) {
        throw new NotYetImplementedException();
    }

    @Override
    public void removeAnimal(Animal animal) {
        throw new NotYetImplementedException();
    }

    @Override
    public void updateAnimal(Animal animal) {
        throw new NotYetImplementedException();
    }
}
