package com.matera.rest.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class TaxIdUtils {

    private static final Pattern ONLY_DIGIT_REGEX = Pattern.compile("^[0-9]*$");
    private static String MASK_CPF = ".***.***-";
    private static String MASK_CNPJ = ".***.***/****-";

    public String formatTaxId(BigDecimal taxId) {
        if (taxId.toString().length() > 11) {
            return StringUtils.leftPad(taxId.toString(), 14, "0");
        } else {
            return StringUtils.leftPad(taxId.toString(), 11, "0");
        }
    }

    public String getTipoPessoa(String taxId) {
        if (taxId.length() <= 11) {
            return "F";
        } else {
            return "J";
        }
    }

    public String convertTaxIdToTaxIdMasked(String taxId) {
        if (taxId != null) {
            if (taxId.length() > 11) {
                return taxId.substring(0, 2) + MASK_CNPJ + taxId.substring(taxId.length() - 2);
            } else {
                return "***." + taxId.substring(3, 6) + "." + taxId.substring(6, 9) + "-**";
            }
        }
        return null;
    }

}
