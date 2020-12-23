package com.matera.rest.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .findVehicleByLicensePlate(licensePlate)
                .orElse(null);
    }
}
