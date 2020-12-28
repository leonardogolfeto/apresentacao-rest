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

    public Car insertCar(CarDTO car) {
        return carRepository.save(new Car(car));
    }

    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }

    public Car alterCar(Integer carId, CarDTO carDTO) {
        Car alteredCar = carRepository.findByCarId(carId);
        alteredCar.setCarBrand(carDTO.getCarBrand());
        alteredCar.setCarCountry(carDTO.getCarCountry());
        alteredCar.setCarId(carDTO.getCarId());
        alteredCar.setCarModel(carDTO.getCarModel());
        alteredCar.setCarOwnerId(carDTO.getCarOwnerId());
        alteredCar.setCarReleaseYear(carDTO.getCarReleaseYear());
        return carRepository.save(alteredCar);
    }
}
