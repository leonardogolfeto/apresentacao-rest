package com.matera.rest.person;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class PersonDTO implements PersonProjection {

    public PersonDTO() {
    }

    public PersonDTO(Person person){

    }

    @NotNull
    private Long taxId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String city;

    private LocalDate birthDate;

    @Override
    public Long getTaxId() {
        return taxId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }
}
