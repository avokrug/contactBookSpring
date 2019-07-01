package com.example.contactBookSpring.repository;

import com.example.contactBookSpring.domain.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findByLink(String link);
}
