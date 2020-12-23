package com.matera.rest.car;

import javax.persistence.Column;
import javax.persistence.Id;

public class CarDTO implements CarProjection {

    public CarDTO(){

    }

    private Integer carId;

    private Integer carReleaseYear;

    private String carModel;

    private String carBrand;

    private String carCountry;

    private Long carOwnerId;

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
    public String getCarBrand() {
        return carBrand;
    }

    @Override
    public String getCarCountry() {
        return carCountry;
    }

    @Override
    public Long getCarOwnerId() {
        return carOwnerId;
    }
}
