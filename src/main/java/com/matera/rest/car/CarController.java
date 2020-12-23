package com.matera.rest.car;

import com.matera.rest.person.PersonDTO;
import com.matera.rest.util.PersonAndCar;
import com.matera.rest.person.Person;
import com.matera.rest.person.PersonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public Car getCarById(@PathVariable("carId") Integer carId) {                   // Find Car By ID
        return carService.getCarByCarId(carId);
    }

    @GetMapping
    public List<Car> getCars() {                                                    // Find Cars
        return carService.findAll();
    }

    @GetMapping("/search/{carId}")
    public PersonAndCar getCarOwnerByCarId(@PathVariable("carId") Integer carId) {  // Find the Owner Car By ID
        Car car = carService.getCarByCarId(carId);
        Person person = personController.getPersonById(car.getCarOwnerId());
        return new PersonAndCar(person, car);
    }

    @PostMapping
    public Car insertCar(@RequestBody @Valid Car car) {                             // Insert a Car
        return carService.insertCar(car);
    }


}
