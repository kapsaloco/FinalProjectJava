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

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
