package com.matera.rest.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Car implements CarProjection {


    public Car() {

    }

    public Car(CarDTO carDTO) {
        this.carId= carDTO.getCarId();
        this.licensePlate = carDTO.getLicensePlate();
        this.color = carDTO.getColor();
        this.model = carDTO.getModel();
        this.brand = carDTO.getBrand();
        this.year = carDTO.getYear();
    }

    public Car(Long carId, String licensePlate, String color, String model, String brand, Integer year) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.color = color;
        this.model = model;
        this.brand = brand;
        this.year = year;
    }

    @Override
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Id
    @Column(name = "CAR_ID")
    private Long carId;

    @Column(name = "LICENSE_PLATE")
    private String licensePlate;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "YEAR")
    private Integer year;



}
