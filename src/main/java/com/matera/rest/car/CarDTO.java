package com.matera.rest.car;

import javax.persistence.Column;
import javax.persistence.Id;

public class CarDTO implements CarProjection {

    public CarDTO(){

    }

    private Integer carId;

    private Integer carReleaseYear;

    private String carModel;

    private String carColor;

    private String carCountry;

    private Integer carOwnerId;

    @Override
    public Integer getCarId() {
        return carId;
    }

    @Override
    public Integer getCarReleaseYear() {
        return carReleaseYear;
    }

    @Override
    public String getCarModel() {
        return carModel;
    }

    @Override
    public String getCarColor() {
        return carColor;
    }

    @Override
    public String getCarCountry() {
        return carCountry;
    }

    @Override
    public Integer getCarOwnerId() {
        return carOwnerId;
    }
}
