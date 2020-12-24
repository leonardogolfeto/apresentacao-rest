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
    public Vehicle getVehicleByLicensePlate(@PathVariable("licensePlate") final String licensePlate) {
        return vehicleService
                .getVehicleByLicensePlate(licensePlate)
                .orElse(null);
    }

    @GetMapping
    public List<Vehicle> getVehiclesBy(
            @RequestParam(value = "licensePlate", required = false) final String licensePlate,
            @RequestParam(value = "model", required = false) final String model,
            @RequestParam(value = "brand", required = false) final String brand,
            @RequestParam(value = "color", required = false) final String color,
            @RequestParam(value = "year", required = false) final Integer year
    ) {
        return vehicleService.getVehiclesBy(licensePlate, model, brand, color, year);
    }

    @PostMapping
    public Vehicle insertVehicle (@RequestBody @Valid final VehicleDTO vehicle) {
        return vehicleService.insertVehicle(vehicle);
    }

    @DeleteMapping("/{licensePlate}")
    public void deleteVehicle(@PathVariable final String licensePlate){
        vehicleService.deleteVehicle(licensePlate);
    }

    @PutMapping("/{licensePlate}")
    public Vehicle alterVehicle(
            @PathVariable("licensePlate") final String licensePlate,
            @RequestBody final VehicleDTO vehicleDTO
    ){
        return vehicleService.alterVehicle(licensePlate, vehicleDTO);
    }
}
