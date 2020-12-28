package com.matera.rest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractTest {

    protected MockMvc mockMvc;

    @Autowired private WebApplicationContext wac;

    @BeforeEach public void setupMockMvc() {
        // criando um client REST para acessar os endpoints utilizados nos testes dessa classe
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
    }
}
