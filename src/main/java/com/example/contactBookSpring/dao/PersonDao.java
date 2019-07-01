package com.example.contactBookSpring.dao;

import com.example.contactBookSpring.domain.Contact;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonDao {
    private Integer id;
    private String name;
    private Set<Contact> contact;

    public PersonDao() {
    }

    public PersonDao(Integer id, String name, Set<Contact> contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public PersonDao(String name, Contact... contacts) {
        this.name = name;
        this.contact = Stream.of(contacts).collect(Collectors.toSet());
        this.contact.forEach(x -> new Contact(x.getPersonId(), x.getType(), x.getLink()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getContact() {
        return contact;
    }

    public void setContact(Set<Contact> contact) {
        this.contact = contact;
    }
}
