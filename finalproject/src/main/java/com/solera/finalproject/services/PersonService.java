package com.solera.finalproject.services;

import com.solera.finalproject.models.Person;
import com.solera.finalproject.repositories.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    // Service layer used for business logic. Not really a need for this project.
    public List<Person> getAllPerson() {
        //List<Person> personList = null;
        //personList = personRepository.findAll();
        return personRepository.findAll();
    }
    public Person insertPerson(Person p) { return personRepository.save(p); }
}
