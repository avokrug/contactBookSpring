package com.example.contactBookSpring.repository;

import com.example.contactBookSpring.domain.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Long> {
    Type findByTypeName(String typeName);
    List<Type> findAll();
}
