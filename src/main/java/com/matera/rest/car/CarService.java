package com.matera.rest.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarByCarId(Integer carId){
        return carRepository.findByCarId(carId);
    }
}
