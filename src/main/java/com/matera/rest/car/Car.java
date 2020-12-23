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
    private String carBrand;

    @Column(name = "CAR_COUNTRY")
    private String carCountry;

    @Column(name = "CAR_OWNER")
    private Long carOwnerId;

    // Constructor's

    public Car(){

    }

    public Car(Integer carId, Integer carReleaseYear, String carModel, String carBrand, String carCountry, Long carOwnerId) {
        this.carId = carId;
        this.carReleaseYear = carReleaseYear;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carCountry = carCountry;
        this.carOwnerId = carOwnerId;
    }

    public Car(CarDTO carDTO) {
        this.carId = carDTO.getCarId();
        this.carReleaseYear = carDTO.getCarReleaseYear();
        this.carModel = carDTO.getCarModel();
        this.carBrand = carDTO.getCarBrand();
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

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarCountry() {
        return carCountry;
    }

    public void setCarCountry(String carCountry) {
        this.carCountry = carCountry;
    }

    public Long getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(Long carOwnerId) {
        this.carOwnerId = carOwnerId;
    }
}
