package com.solera.finalproject.controllers;

import com.solera.finalproject.models.Person;
import com.solera.finalproject.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class PersonController {
    @Autowired
    private PersonService personService;

    @CrossOrigin(origins ="http://localhost:3000")
    @GetMapping(value="/get")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }}
