package com.ciastek.javaacademy.shelter.domain.repository.impl;

import com.ciastek.javaacademy.shelter.domain.Animal;
import com.ciastek.javaacademy.shelter.domain.repository.AnimalRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NotYetImplementedException;
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

    @Override
    public void addAnimal(Animal animal) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(animal);
    }
}
