package com.matera.rest.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> findVehicleByLicensePlate(String licensePlate) {
        return this.vehicleRepository.findById(licensePlate);
    }

    //TODO Implement HTTP request methods
}
