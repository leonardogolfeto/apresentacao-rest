package com.matera.rest.utils;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaxIdUtilsTest {

    @Test
    public void getTipoPessoaFisica() {
        TaxIdUtils taxIdUtils = new TaxIdUtils();
        String tipoPessoa = taxIdUtils.getTipoPessoa("09854430901");
        Assertions.assertEquals(tipoPessoa, "F");
    }

    @Test
    public void getTipoPessoaJuridica() {
        TaxIdUtils taxIdUtils = new TaxIdUtils();
        String tipoPessoa = taxIdUtils.getTipoPessoa("80345267000180");
        Assertions.assertEquals(tipoPessoa, "J");
    }

    @Test
    public void formatTaxId() {
        TaxIdUtils taxIdUtils = new TaxIdUtils();
        String tipoPessoa = taxIdUtils.formatTaxId(BigDecimal.valueOf(9854430901L));
        Assertions.assertEquals(tipoPessoa, "09854430901");
    }

    @Test
    public void convertTaxIdToTaxIdMasked() {
        TaxIdUtils taxIdUtils = new TaxIdUtils();
        String tipoPessoa = taxIdUtils.convertTaxIdToTaxIdMasked("09854430901");
        Assertions.assertEquals(tipoPessoa, "***.544.309-**");
    }
}