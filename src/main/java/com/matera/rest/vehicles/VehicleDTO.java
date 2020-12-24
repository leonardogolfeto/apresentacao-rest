package com.matera.rest.vehicles;

import javax.validation.constraints.NotNull;

public class VehicleDTO implements VehicleProjection {
    public VehicleDTO() {


    }

    @NotNull
    private long id;

    @NotNull
    private String plate;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
