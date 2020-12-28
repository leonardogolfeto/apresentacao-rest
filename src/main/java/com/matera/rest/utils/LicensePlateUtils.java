package com.matera.rest.utils;

import antlr.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;


@Component
public class LicensePlateUtils {
    private static final Pattern ONLY_DIGIT_REGEX = Pattern.compile("^[0-9]*$");
    private static final Pattern ONLY_ALPHABETIC_REGEX = Pattern.compile("^[a-zA-Z]*$");
    //private static String MASK_DENATRAN = "###-****";
    //private static String MASK_MERCOSUL = "###*#**";

    public String convertLicensePlateToLicensePlateMasked(String licensePlate) {
        if (licensePlate != null) {
            if (Character.isLetter(licensePlate.charAt(4)) && licensePlate.length() == 7) {
                return licensePlate;
            } else if (licensePlate.charAt(3) == '-' && licensePlate.length() == 8) {
                return licensePlate;
            } else if (Character.isDigit(licensePlate.charAt(4)) && licensePlate.length() == 7) {
                return licensePlate.substring(0, 3) + "-" + licensePlate.substring(3, 7);
            }
        }
        return null;
    }

}
