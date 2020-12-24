package com.matera.rest.car;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDTO implements CarProjection{
    // Gets and variables

    public CarDTO() {

    }

    @NotNull
    private Long carId;
    @NotNull
    @Size(min = 7, max = 7)
    private String licensePlate;
    private String color;
    @NotNull
    private String model;
    @NotNull
    private String brand;
    @Size(min = 4, max = 4)
    private Integer year;

    public Long getCarId() {
        return this.carId;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public String getColor() {
        return this.color;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public Integer getYear() {
        return this.year;
    }
}

