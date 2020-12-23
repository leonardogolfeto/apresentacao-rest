package com.matera.rest.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarByCarId(Integer carId){
        return carRepository.findByCarId(carId);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car insertCar(Car car) {
        return carRepository.save(car);
    }
}
