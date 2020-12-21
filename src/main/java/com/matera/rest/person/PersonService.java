package com.matera.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonByTaxId(Long taxId){
        return personRepository.findByTaxId(taxId);
    }

    public List<Person> getPersons(Long taxId,
                                   String firstName,
                                   String lastName,
                                   String city,
                                   Date birthDate){

        Specification<Person> personSpecification;

        personSpecification = Specification
                .where(getSpecByParam("taxId", taxId))
                .and(getSpecByParam("firstName", firstName))
                .and(getSpecByParam("lastName", lastName))
                .and(getSpecByParam("city", city))
                .and(getSpecByParam("birthDate", birthDate));

        return personRepository.findAll(personSpecification);
    }

    private Specification<Person> getSpecByParam(String name, Object parameterValue) {

        if(parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(name), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(name));
    }

}
