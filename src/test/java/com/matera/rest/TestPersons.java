package com.matera.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = RANDOM_PORT)
class TestPersons extends AbstractTest{

    private static final String GET_PERSONS_ENDPOINT = "/v1/persons";
    private static final String GET_PERSONS_BY_SEX_ENDPOINT = "/v1/persons/sex/";

    @Test
    public void testApiPersonsShouldSucess() throws Exception {
        this.mockMvc.perform(get(GET_PERSONS_ENDPOINT)).andDo(print()).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void testApiPersonsByNameShouldSucess() throws Exception {
        this.mockMvc.perform(get(GET_PERSONS_ENDPOINT+"?firstName={firstName}","Maria"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("[0].firstName").value("Maria"));
    }

    @Test
    public void testApiPersonsGetAllMans() throws Exception {
        MvcResult mans = this.mockMvc.perform(get(GET_PERSONS_BY_SEX_ENDPOINT + "0")).andDo(print())
                .andExpect(status().isOk()).andReturn();

        Long taxId = JsonPath.read(mans.getResponse().getContentAsString(), "[0].taxId");

        assertTrue(taxId % 2 == 0);

    }

    @Test
    public void testApiPersonsGetAllWomans() throws Exception {
        MvcResult womans = this.mockMvc.perform(get(GET_PERSONS_BY_SEX_ENDPOINT + "1")).andDo(print())
                .andExpect(status().isOk()).andReturn();

        Long taxId = JsonPath.read(womans.getResponse().getContentAsString(), "[0].taxId");

        assertFalse(taxId % 2 == 0);

    }
}


