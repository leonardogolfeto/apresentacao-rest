package com.matera.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @GetMapping
    public List<Person> getPersonBy(@RequestParam(value = "taxId", required = false) Long taxId,
                                              @RequestParam(value = "firstName", required = false) String firstName,
                                              @RequestParam(value ="lastName", required = false) String lastName,
                                              @RequestParam(value ="city", required = false) String city,
                                              @RequestParam(value ="birthDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {

        return  personService.getPersons(taxId, firstName, lastName, city, birthDate);
    }

    @PostMapping
    public Person insertPerson(@RequestBody @Valid PersonDTO person){
        return personService.insertPerson(person);
    }

    @PutMapping("/{taxId}")
    public Person alterPerson(@PathVariable("taxId") Long taxId, @RequestBody PersonDTO personDTO){
        return personService.alterPerson(taxId, personDTO);

    }

    @DeleteMapping("/{taxId}")
    public void deletePerson(@PathVariable("taxId") Long taxId){
        personService.deletePerson(taxId);
    }


}
