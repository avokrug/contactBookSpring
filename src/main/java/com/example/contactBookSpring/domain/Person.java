package com.example.contactBookSpring.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private Set<Contact> contact = new HashSet<>();

    public Person() {
    }

    public Person(String name, Set<Contact> contact) {
        this.name = name;
        this.contact = contact;
    }

    public Person(String name, Contact... contacts) {
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
