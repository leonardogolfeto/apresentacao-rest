package com.matera.rest.vehicle;

import org.springframework.beans.factory.annotation.Autowired;

public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    //TODO Implement HTTP request methods
}
