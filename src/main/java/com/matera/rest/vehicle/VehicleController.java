package com.matera.rest.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{licensePlate}")
    public Vehicle getVehicleByLicensePlate(@PathVariable String licensePlate) {
        return vehicleService
                .getVehicleByLicensePlate(licensePlate)
                .orElse(null);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping
    public Vehicle insertVehicle (@RequestBody @Valid final VehicleDTO vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }
}
