package com.matera.rest.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle implements VehicleProjection{

    @Id
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "YEAR")
    private Integer year;

    public Vehicle() {

    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this.licensePlate = vehicleDTO.getLicensePlate();
        this.model = vehicleDTO.getModel();
        this.brand = vehicleDTO.getBrand();
        this.color = vehicleDTO.getColor();
        this.year = vehicleDTO.getYear();
    }


    public Vehicle(String licensePlate, String model, String brand, String color, Integer year) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
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
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
