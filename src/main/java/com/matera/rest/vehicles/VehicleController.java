package com.matera.rest.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long id){
        return vehicleService.getVehicleByTaxId(id);
    }

    @GetMapping
    public List<Vehicle> getVehicleBy(@RequestParam(value = "id", required = false) Long id,
                                    @RequestParam(value = "model", required = false) String model,
                                    @RequestParam(value ="plate", required = false) String plate,
                                    @RequestParam(value ="brand", required = false) String brand,
                                    @RequestParam(value ="color", required = false) String color) {

        return  vehicleService.getVehicles(id, model, plate, brand, color);
    }

    @PostMapping
    public Vehicle insertVehicle(@RequestBody @Valid VehicleDTO vehicle){
        return vehicleService.insertVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle alterVehicle(@PathVariable("id") Long id, @RequestBody VehicleDTO vehicleDTO){
        return vehicleService.alterVehicle(id, vehicleDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id){
        vehicleService.deleteVehicle(id);
    }


}
