package com.matera.rest.vehicle;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {


    List<Vehicle> findAll(Specification<VehicleProjection> vehicleSpecification);
}
