package com.matera.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{taxId}")
    public Person getPersonById(@PathVariable("taxId") Long taxId){
        return personService.getPersonByTaxId(taxId);
    }

    @GetMapping("/sex/{sex}")
    public List<Person> getPersonBySex(@PathVariable("sex") Long sex){
        return personService.getPersonOnlyOneSex(sex);
    }

    @GetMapping
    public List<Person> getPersonBy(@RequestParam(value = "taxId", required = false) Long taxId,
                                      @RequestParam(value = "firstName", required = false) String firstName,
                                      @RequestParam(value ="lastName", required = false) String lastName,
                                      @RequestParam(value ="city", required = false) String city,
                                      @RequestParam(value ="birthDate", required = false) Date birthDate) {

        return  personService.getPersons(taxId, firstName, lastName, city, birthDate);
    }


}
