package com.solera.finalproject.controllers;

import com.solera.finalproject.models.Person;
import com.solera.finalproject.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
// Context path is /api/...
public class PersonController {
    @Autowired
    private PersonService personService;


    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return new ResponseEntity<>(
                personService.getAllPerson(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> postPerson(@RequestBody Person p) {
        return new ResponseEntity<>(
                personService.insertPerson(p),
                HttpStatus.OK
        );
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person p) {

        Person updatedPerson = personService.updatePerson(p);
        // Included a person without ID
        HttpStatus code = updatedPerson != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                updatedPerson,
                code
        );
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestBody Person p) {
        personService.deletePerson(p);
        return new ResponseEntity<>(
                "Successfully deleted person with id: " + p.getId(),
                HttpStatus.OK
        );
    }

}