package com.matera.rest.car;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByCarId(Long carId);

    //List<Car> findAll();

    List<Car> findAll(Specification<CarProjection> carSpecification);

}
