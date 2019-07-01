package com.example.contactBookSpring.service;

import com.example.contactBookSpring.dao.ContactDao;
import com.example.contactBookSpring.dao.PersonDao;
import com.example.contactBookSpring.dao.TypeDao;
import com.example.contactBookSpring.domain.Contact;
import com.example.contactBookSpring.domain.Person;
import com.example.contactBookSpring.domain.Type;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public Service() {
    }

    public List<PersonDao> personConverterToDTO(List<Person> personList){
        return personList.stream().map(x -> new PersonDao(x.getId(), x.getName(), x.getContact())).collect(Collectors.toList());
    }

    public List<ContactDao> contactConverterToDTO(List<Contact> contactList){
        return contactList.stream().map(x -> new ContactDao(x.getId(), x.getPersonId(), x.getType(), x.getLink())).collect(Collectors.toList());
    }

    public List<TypeDao> typeConverterToDTO(List<Type> typeList){
        return typeList.stream().map(x -> new TypeDao(x.getId(), x.getTypeName())).collect(Collectors.toList());
    }

    public PersonDao personConverterToDTO(Person person){
        return new PersonDao(person.getId(), person.getName(), person.getContact());
    }
}
