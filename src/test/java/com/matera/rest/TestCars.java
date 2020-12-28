package com.matera.rest;

import com.matera.rest.utils.LicensePlateUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCars extends AbstractTest {

    /* @Mock
    CarService carService;
*/
    private static final String GET_CARS_ENDPOINT = "/cars";

    @Autowired
    private LicensePlateUtils licensePlateUtils;

    @Test
    public void testApiCarsShouldSuccess() throws Exception {
        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(carController).build();

        this.mockMvc.perform(get(GET_CARS_ENDPOINT))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(print());
    }
}
