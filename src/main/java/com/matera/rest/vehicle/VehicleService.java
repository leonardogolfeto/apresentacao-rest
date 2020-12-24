package com.matera.rest.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> getVehicleByLicensePlate(final String licensePlate) {
        return this.vehicleRepository.findById(licensePlate);
    }

    private Specification<VehicleProjection> getSpecByParam(String name, Object parameterValue) {

        if(parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(name), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(name));
    }

    public List<Vehicle> getVehiclesBy(
            final String licensePlate,
            final String model,
            final String brand,
            final String color,
            final Integer year
    ) {
        Specification<VehicleProjection> vehicleSpecification;

        vehicleSpecification = Specification
                .where(getSpecByParam("licensePlate", licensePlate))
                .and(getSpecByParam("model", model))
                .and(getSpecByParam("brand", brand))
                .and(getSpecByParam("color", color))
                .and(getSpecByParam("year", year));

        return vehicleRepository.findAll(vehicleSpecification);
    }

    public Vehicle insertVehicle (VehicleDTO vehicle) {
        return vehicleRepository.save(new Vehicle(vehicle));
    }

    public void deleteVehicle(final String licensePlate){
        vehicleRepository.deleteById(licensePlate);
    }
}
