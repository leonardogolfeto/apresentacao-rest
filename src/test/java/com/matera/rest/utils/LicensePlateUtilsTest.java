package com.matera.rest.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class LicensePlateUtilsTest {

    @Test
    void convertLicensePlateToLicensePlateMasked() {
        LicensePlateUtils licensePlateUtils = new LicensePlateUtils();
        String typePlate = licensePlateUtils.convertLicensePlateToLicensePlateMasked("FIW2049");
        Assertions.assertEquals(typePlate, "FIW-2049");
    }

    @Test
    void convertLicensePlateMercosul() {
        LicensePlateUtils licensePlateUtils = new LicensePlateUtils();
        String typePlate = licensePlateUtils.convertLicensePlateToLicensePlateMasked("FIW2K59");
        Assertions.assertEquals(typePlate, "FIW2K59");
    }
    @Test
    void convertLicensePlateDenatran() {
        LicensePlateUtils licensePlateUtils = new LicensePlateUtils();
        String typePlate = licensePlateUtils.convertLicensePlateToLicensePlateMasked("FIW-2359");
        Assertions.assertEquals(typePlate, "FIW-2359");
    }
}