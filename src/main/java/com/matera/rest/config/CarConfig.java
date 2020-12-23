package com.matera.rest.config;

import com.matera.rest.car.Car;
import com.matera.rest.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CarConfig {

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    private void init(){
        for (int i = 0; i < 5; i++)
            carRepository.save(getCar(i));
    }

    private Car getCar(int index) {

        List<Integer> carIds = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> carReleaseYears = Arrays.asList(1998, 2001, 2003, 2007, 20014);

        List<String> carModels = Arrays.asList("Convertible", "Sedan", "SUV", "Minivan", "Sport Car");

        List<String> carBrands = Arrays.asList("BMW", "Toyota", "Hyundai", "Honda", "Porsche");

        List<String> carCountries = Arrays.asList("Canada", "Brasil", "Japao", "Tailandia", "Alemanha");

        List<Integer> carOwnerIds = Arrays.asList(3, 9, 27, 81, 243);

        Car car_instance = new Car(carIds.get(index),
                carReleaseYears.get(index),
                carModels.get(index),
                carBrands.get(index),
                carCountries.get(index),
                carOwnerIds.get(index));

        return car_instance;

    }
}
