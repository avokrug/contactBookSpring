package com.example.contactBookSpring;

import com.example.contactBookSpring.dao.PersonDao;

import com.example.contactBookSpring.dao.TypeDao;
import com.example.contactBookSpring.domain.Contact;
import com.example.contactBookSpring.domain.Person;
import com.example.contactBookSpring.domain.Type;
import com.example.contactBookSpring.repository.ContactRepository;
import com.example.contactBookSpring.repository.PersonRepository;
import com.example.contactBookSpring.repository.TypeRepository;
import com.example.contactBookSpring.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ContactRepository contactRepository;
    private Service service = new Service();

    @GetMapping
    public String main(Model model, HttpServletRequest request) {
        getAttr(model);
        model.addAttribute("type", new TypeDao());
        return "main";
    }

    @PostMapping(value="/new_person")
    public String newPerson(@ModelAttribute Person person, Contact contact, Type type) {
        personRepository.save(new Person(person.getName(), new Contact(null, typeRepository.findByTypeName(type.getTypeName()), contact.getLink())));
        return "main";
    }

    @PostMapping(value="/add_link")
    public String addLink(@ModelAttribute Person person, Contact contact, Type type) {
        contactRepository.save(new Contact(person.getId(), typeRepository.findByTypeName(type.getTypeName()), contact.getLink()));
        return "main";
    }

    @GetMapping("/add_contact/{idPerson}")
    public String addContact(Model model, @PathVariable Integer idPerson) {
        List<TypeDao> typeList = service.typeConverterToDTO(typeRepository.findAll());
        model.addAttribute("person", personRepository.findById(idPerson));
        model.addAttribute("contact", new Contact());
        model.addAttribute("typeList", typeList);
        model.addAttribute("type", new Type());
        return "add_contact";
    }

    @PostMapping(value="/find_contact")
    public String findPage(@ModelAttribute Contact contact, Model model) {
        PersonDao person = new PersonDao();
        if (contact.getLink() != null){
            Contact findContact = contactRepository.findByLink(contact.getLink());
            if (findContact != null) {
                person = service.personConverterToDTO(personRepository.findById(findContact.getPersonId()));
            }
        }
        model.addAttribute("person_list", person);
        model.addAttribute("contact",new Contact());
        getAttr(model);
        model.addAttribute("type", new Type());
        return "find_contact";
    }

    private void getAttr(Model model) {
        List<PersonDao> persons = service.personConverterToDTO(personRepository.findAll());
        List<TypeDao> typeList = service.typeConverterToDTO(typeRepository.findAll());
        model.addAttribute("persons", persons);
        model.addAttribute("person", new Person());
        model.addAttribute("contact", new Contact());
        model.addAttribute("typeList", typeList);
    }
}
