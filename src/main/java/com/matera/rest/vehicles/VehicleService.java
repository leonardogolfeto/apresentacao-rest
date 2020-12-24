package com.matera.rest.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicleByTaxId(Long id){
        return vehicleRepository.findById(id);
    }

    public List<Vehicle> getVehicles(Long id,
                                     String plate,
                                     String brand,
                                     String model,
                                   String color){

        Specification<VehicleProjection> vehicleSpecification;

        vehicleSpecification = Specification
                .where(getSpecByParam("id", id))
                .and(getSpecByParam("model", model))
                .and(getSpecByParam("brand", brand))
                .and(getSpecByParam("plate", plate))
                .and(getSpecByParam("color", color));

        return vehicleRepository.findAll(vehicleSpecification);
    }

    private Specification<VehicleProjection> getSpecByParam(String plate, Object parameterValue) {

        if(parameterValue != null) {
            return (root, criteriaQuery, cb) -> cb.equal(root.get(plate), parameterValue);
        }

        return (root, criteriaQuery, cb) -> cb.isNotNull(root.get(plate));
    }

    public Vehicle insertVehicle(VehicleDTO vehicle) {

        return vehicleRepository.save(new Vehicle(vehicle));

    }

    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);

    }

    public Vehicle alterVehicle(Long id, VehicleDTO vehicleDTO) {

        Vehicle alteredVehicle = vehicleRepository.getOne(id);
        alteredVehicle.setId(Optional.ofNullable(vehicleDTO.getId()).orElse(alteredVehicle.getId()));
        alteredVehicle.setModel(Optional.ofNullable(vehicleDTO.getModel()).orElse(alteredVehicle.getModel()));
        alteredVehicle.setBrand(Optional.ofNullable(vehicleDTO.getBrand()).orElse(alteredVehicle.getBrand()));
        alteredVehicle.setPlate(Optional.ofNullable(vehicleDTO.getPlate()).orElse(alteredVehicle.getPlate()));
        alteredVehicle.setColor(Optional.ofNullable(vehicleDTO.getColor()).orElse(alteredVehicle.getColor()));

        return vehicleRepository.save(alteredVehicle);
    }
}

