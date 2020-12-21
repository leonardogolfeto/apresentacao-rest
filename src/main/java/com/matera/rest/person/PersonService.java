package com.matera.rest.person;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonByTaxId(Long taxId) {
        return personRepository.findByTaxId(taxId);
    }

    //0 Woman
    //1 Man
    public List<Person> getPersonOnlyOneSex(Long sex) {
        List<Person> all = personRepository.findAll();
        if (sex == 0) {
            return all.stream().filter(person -> person.getTaxId() % 2 == 0).collect(Collectors.toList());
        }
        return all.stream().filter(person -> person.getTaxId() % 2 != 0).collect(Collectors.toList());
    }

    public List<Person> getPersons(Long taxId, String firstName, String lastName, String city, Date birthDate) {

        Specification<Person> personSpecification;

        personSpecification = Specification.where(getSpecByParam("taxId", taxId))
                .and(getSpecByParam("firstName", firstName)).and(getSpecByParam("lastName", lastName))
                .and(getSpecByParam("city", city)).and(getSpecByParam("birthDate", birthDate));

        return personRepository.findAll(personSpecification);
    }

    private Specification<Person> getSpecByParam(String name, Object parameterValue) {

        if (parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(name), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(name));
    }

}
