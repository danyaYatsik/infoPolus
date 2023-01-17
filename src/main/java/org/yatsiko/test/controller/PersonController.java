package org.yatsiko.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yatsiko.test.dto.PersonDto;
import org.yatsiko.test.service.PersonService;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/persons")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(path = "/persons/{id}")
    public PersonDto getPersonById(@PathVariable("id") long id) {
        return personService.getPersonById(id);
    }
}
