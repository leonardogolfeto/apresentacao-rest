package com.matera.rest.car;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car implements CarProjection{

    // Attributes
    @Id
    @Column(name = "CAR_ID")
    private Integer carId;

    @Column(name = "RELEASE_YEAR")
    private Integer carReleaseYear;

    @Column(name = "CAR_MODEL")
    private String carModel;

    @Column(name = "CAR_COLOR")
    private String carColor;

    @Column(name = "CAR_COUNTRY")
    private String carCountry;


    @Column(name = "CAR_OWNER")
    private Integer carOwnerId;

    // Constructor's

    public Car(){

    }

    public Car(Integer carId, Integer carReleaseYear, String carModel, String carColor, String carCountry, Integer carOwnerId) {
        this.carId = carId;
        this.carReleaseYear = carReleaseYear;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carCountry = carCountry;
        this.carOwnerId = carOwnerId;
    }

    public Car(CarDTO carDTO) {
        this.carId = carDTO.getCarId();
        this.carReleaseYear = carDTO.getCarReleaseYear();
        this.carModel = carDTO.getCarModel();
        this.carColor = carDTO.getCarColor();
        this.carCountry = carDTO.getCarCountry();
        this.carOwnerId = carDTO.getCarOwnerId();
    }

    // Getter's and Setter's


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarReleaseYear() {
        return carReleaseYear;
    }

    public void setCarReleaseYear(Integer carReleaseYear) {
        this.carReleaseYear = carReleaseYear;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarCountry() {
        return carCountry;
    }

    public void setCarCountry(String carCountry) {
        this.carCountry = carCountry;
    }

    public Integer getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(Integer carOwnerId) {
        this.carOwnerId = carOwnerId;
    }
}
