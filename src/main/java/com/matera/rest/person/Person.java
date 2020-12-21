package com.matera.rest.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Person implements PersonProjection {

    public Person() {
    }

    public Person(PersonDTO personDTO) {
        this.taxId = personDTO.getTaxId();
        this.firstName = personDTO.getFirstName();
        this.lastName = personDTO.getLastName();
        this.city = personDTO.getCity();
        this.birthDate = personDTO.getBirthDate();
    }


    public Person(Long taxId, String firstName, String lastName, String city, LocalDate birthDate) {
        this.taxId = taxId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthDate = birthDate;
    }

    @Id
    @Column(name = "TAX_ID")
    private Long taxId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Override
    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
