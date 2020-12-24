package com.matera.rest;

import com.matera.rest.car.CarRepository;
import com.matera.rest.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	@Autowired
	private PersonRepository personRepository;
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
