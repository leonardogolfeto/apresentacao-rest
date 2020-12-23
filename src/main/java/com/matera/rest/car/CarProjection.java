package com.matera.rest.car;

public interface CarProjection {
    // Only Gets
    Long getCarId();

    String getLicensePlate();

    String getColor();

    String getModel();

    String getBrand();

    Integer getYear();
}
