package com.solera.finalproject.services;

import com.solera.finalproject.models.Person;
import com.solera.finalproject.repositories.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    public Person insertPerson(Person p) {
        return personRepository.save(p);
    }

    public void deletePerson(Person p) {
        personRepository.delete(p);
    }

    public Person updatePerson(Person p){
        if(personRepository.findById(p.getId()).orElse((null)) == null){
            return null;
        } else {
            return personRepository.save(p);
        }
    }
}
