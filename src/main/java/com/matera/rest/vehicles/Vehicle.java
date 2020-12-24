package com.matera.rest.vehicles;

import javax.persistence.Column;
import javax.persistence.Id;

public class Vehicle implements VehicleProjection {
    public Vehicle() {

    }

    public Vehicle(VehicleDTO vehicleDTO) {
        this.id = vehicleDTO.getId();
        this.plate = vehicleDTO.getPlate();
        this.brand = vehicleDTO.getBrand();
        this.model = vehicleDTO.getModel();
        this.color = vehicleDTO.getColor();
    }

    public Vehicle (long id, String plate, String brand, String model, String color) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PLATE")
    private String plate;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
