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

        List<Integer> carReleaseYears = Arrays.asList(1998, 2001, 2003, 2007, 2014);

        List<String> carModels = Arrays.asList("Convertible", "Sedan", "SUV", "Minivan", "Sport Car");

        List<String> carBrands = Arrays.asList("BMW", "Toyota", "Hyundai", "Honda", "Porsche");

        List<String> carCountries = Arrays.asList("Canada", "Brasil", "Japao", "Tailandia", "Alemanha");

        List<Long> carOwnerIds = Arrays.asList(11130913988L, 10508510058L, 52557200034L, 42908466023L, 82132300003L);

        return new Car(carIds.get(index),
                carReleaseYears.get(index),
                carModels.get(index),
                carBrands.get(index),
                carCountries.get(index),
                carOwnerIds.get(index));

    }
}
