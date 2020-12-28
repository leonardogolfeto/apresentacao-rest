package com.matera.rest.car;

import com.matera.rest.person.PersonDTO;
import com.matera.rest.util.PersonAndCar;
import com.matera.rest.person.Person;
import com.matera.rest.person.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private PersonController personController;

    @Autowired
    private CarController carController;

    @Autowired
    private CarService carService;

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable("carId") Integer carId) {                       // Find Car By ID
        return carService.getCarByCarId(carId);
    }

    @GetMapping
    public List<Car> getCars() {                                                        // Find Cars
        return carService.findAll();
    }

    @GetMapping("/search/{carId}")
    public List<Object> getCarOwnerByCarId(@PathVariable("carId") Integer carId) {  // Find Owner Car By ID
        Car car = carService.getCarByCarId(carId);
        Person person = personController.getPersonById(car.getCarOwnerId());
        ArrayList<Object> carAndOwner = new ArrayList<Object>();
        carAndOwner.add(car);carAndOwner.add(person);
        return carAndOwner;
    }

    @PostMapping("/insert")
    public Car insertCar(@RequestBody @Valid CarDTO car) {                                 // Insert a Car
        return carService.insertCar(car);
    }

    @DeleteMapping("/delete/{carId}")
    public void deleteCar(@PathVariable("carId") Integer carId) {
        carService.deleteCar(carId);
    }

    @PutMapping("/put/{carId}")                                                     // Edit
    public Car modifyCar(@PathVariable("carId") Integer carId, @RequestBody CarDTO carDTO ) {
        return carService.alterCar(carId, carDTO);
    }

}
