package com.matera.rest.util;

import com.matera.rest.car.Car;
import com.matera.rest.person.Person;

public class PersonAndCar {

    private Person person;
    private Car car;

    // Constructor's

    public PersonAndCar(){

    }

    public PersonAndCar(Person person, Car car) {
        this.person = person;
        this.car = car;
    }

    // Getter's and Setter's


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
