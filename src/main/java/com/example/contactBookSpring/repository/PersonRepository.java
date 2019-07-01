package com.example.contactBookSpring.repository;

import com.example.contactBookSpring.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    Person findById(Integer id);
    Person findByName(String name);
}
