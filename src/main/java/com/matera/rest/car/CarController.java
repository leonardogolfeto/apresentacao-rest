package com.matera.rest.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/cars")
public class CarController {
    //Controller -> Service -> Repository

    @Autowired
    private CarService carService;


    @GetMapping("/all")
    public List<Car> findAll() {
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


    @GetMapping
    public List<Car> getCarsBy(@RequestParam (value = "carId", required = false) Long carId,
                             @RequestParam (value = "licensePlate", required = false) String licensePlate,
                             @RequestParam (value = "color", required = false) String color,
                             @RequestParam (value = "model", required = false) String model,
                             @RequestParam (value = "brand", required = false) String brand,
                             @RequestParam (value = "year", required = false) String year) {

        return carService.getCars(carId, licensePlate, color, model, brand, year);
    }

    @PutMapping("/{carId}")
    public Car alterCar(@PathVariable (value = "carId") Long carId, @RequestBody @Valid CarDTO car) {
        try {
            return carService.alterCar(carId, car);
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não encontrado", entityNotFoundException);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }



}
