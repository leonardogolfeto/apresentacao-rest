package com.matera.rest.car;

import com.matera.rest.person.PersonProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car getCarById(Long carId) {
        return carRepository.findByCarId(carId);
    }

    public void deleteCarById(Long carId) {
        carRepository.deleteById(carId);
    }

    public Car insertCar(CarDTO car) {
        return carRepository.save(new Car(car));
    }

    public List<Car> getCars(Long carId,
                             String licensePlate,
                             String color,
                             String model,
                             String brand,
                             String year) {

        Specification<CarProjection> carSpecification;

        carSpecification = Specification
                .where(getSpecByParam("carId", carId))
                .and(getSpecByParam("licensePlate", licensePlate))
                .and(getSpecByParam("color", color))
                .and(getSpecByParam("model", model))
                .and(getSpecByParam("brand", brand))
                .and(getSpecByParam("year", year));

        return carRepository.findAll(carSpecification);
    }

    private Specification<CarProjection> getSpecByParam(String name, Object parameterValue) {

        if(parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(name), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(name));
    }

    public Car alterCar(Long carId, CarDTO car) {
        Car carAux = carRepository.getOne(carId);


        carAux.setCarId(Optional.ofNullable(car.getCarId()).orElse(carAux.getCarId()));
        carAux.setLicensePlate(Optional.ofNullable(car.getLicensePlate()).orElse(carAux.getLicensePlate()));
        carAux.setColor(Optional.ofNullable(car.getColor()).orElse(carAux.getColor()));
        carAux.setBrand(Optional.ofNullable(car.getBrand()).orElse(carAux.getBrand()));
        carAux.setModel(Optional.ofNullable(car.getModel()).orElse(carAux.getModel()));
        carAux.setYear(Optional.ofNullable(car.getYear()).orElse(carAux.getYear()));


        return carRepository.save(carAux);
    }
}
