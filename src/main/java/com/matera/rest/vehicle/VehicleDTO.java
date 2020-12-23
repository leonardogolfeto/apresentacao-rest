package com.matera.rest.vehicle;

import javax.validation.constraints.NotNull;

public class VehicleDTO implements VehicleProjection {

    public VehicleDTO() {
    }

    @NotNull
    private String licensePlate;

    @NotNull
    private String model;

    @NotNull
    private String brand;

    @NotNull
    private String color;

    @NotNull
    private Integer year;

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getYear() {
        return this.year;
    }
}
