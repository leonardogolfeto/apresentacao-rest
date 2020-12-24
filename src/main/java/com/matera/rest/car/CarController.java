package com.matera.rest.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {
    //Controller -> Service -> Repository

    @Autowired
    private CarService carService;


    @GetMapping
    public List<Car> all() {
        return carService.findAll();
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable("carId") Long carId) {
        return carService.getCarById(carId);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable("carId") Long carId) {
        carService.deleteCarById(carId);
    }

    @PostMapping
    public Car insertCar(@RequestBody @Valid CarDTO car) {
        return carService.insertCar(car);
    }

    /*
    @GetMapping
    public List<Car> getCars(@PathVariable("carId") Long carId,
                      @PathVariable("licensePlate") String licensePlate,
                      @PathVariable("color") String color,
                      @PathVariable("model") String model,
                      @PathVariable("brand") String brand,
                      @PathVariable("year") String year) {
        return carService.getCars(carId, licensePlate, color, model, brand, year);
    }
     */


}
