package com.spitz.netfinder.repository;

import com.spitz.netfinder.model.Person;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;

@Repository
public interface IPersonRepository extends CrudRepository<Person, Long> {
    public Person findByFirstName(String firstName);
}
