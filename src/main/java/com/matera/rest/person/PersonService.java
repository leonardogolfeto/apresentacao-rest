package com.matera.rest.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
                                             LocalDate birthDate){

        Specification<PersonProjection> personSpecification;

        personSpecification = Specification
                .where(getSpecByParam("taxId", taxId))
                .and(getSpecByParam("firstName", firstName))
                .and(getSpecByParam("lastName", lastName))
                .and(getSpecByParam("city", city))
                .and(getSpecByParam("birthDate", birthDate));

        return personRepository.findAll(personSpecification);
    }

    private Specification<PersonProjection> getSpecByParam(String name, Object parameterValue) {

        if(parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(name), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(name));
    }

    public Person insertPerson(PersonDTO person) {

        return personRepository.save(new Person(person));

    }

    public void deletePerson(Long taxId) {

        personRepository.deleteById(taxId);

    }

    public Person alterPerson(Long taxId, PersonDTO personDTO) {

        Person alteredPerson = personRepository.getOne(taxId);
        alteredPerson.setTaxId(Optional.ofNullable(personDTO.getTaxId()).orElse(alteredPerson.getTaxId()));
        alteredPerson.setFirstName(Optional.ofNullable(personDTO.getFirstName()).orElse(alteredPerson.getFirstName()));
        alteredPerson.setLastName(Optional.ofNullable(personDTO.getLastName()).orElse(alteredPerson.getLastName()));
        alteredPerson.setCity(Optional.ofNullable(personDTO.getCity()).orElse(alteredPerson.getCity()));
        alteredPerson.setBirthDate(Optional.ofNullable(personDTO.getBirthDate()).orElse(alteredPerson.getBirthDate()));

        return personRepository.save(alteredPerson);
    }
}
