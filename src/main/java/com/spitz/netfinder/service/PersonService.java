package com.spitz.netfinder.service;

import com.spitz.netfinder.model.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;

@Named
@ApplicationScoped
public class PersonService {
    @Inject
    private EntityManager em;

    public Person findPerson(int id) {
        return em.find(Person.class, id);
    }
}
