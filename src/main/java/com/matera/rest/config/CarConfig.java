package com.matera.rest.config;

import com.matera.rest.car.Car;
import com.matera.rest.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CarConfig {

    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    private void construct() {
        for (int i = 0; i < 10; i++) {
            carRepository.save(getCar(i));
        }
    }

    private Car getCar(int index) {

        List<Long> carIds = Arrays.asList(11130913988L,
                17600659000L,
                10508510058L,
                83905087022L,
                52557200034L,
                23511361010L,
                42908466023L,
                51126319023L,
                13735125042L,
                82132300003L);

        List<String> licensePlates = Arrays.asList("BUS9021",
                "OLC1875",
                "JDK8112",
                "NRH5091",
                "IRS1942",
                "ASD3224",
                "OFS2952",
                "AER2549",
                "GFO2945",
                "FIW2593");

        List<String> color = Arrays.asList("azul",
                "preto",
                "azul",
                "cinza",
                "branco",
                "preto",
                "preto",
                "vermelho",
                "preto",
                "prata");

        List<String> model = Arrays.asList("Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka",
                "Ka");

        List<String> brand = Arrays.asList("Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford",
                "Ford");

        List<Integer> year = Arrays.asList(1996,
                1987,
                2000,
                2005,
                2006,
                2010,
                2020,
                2019,
                2001,
                2012);

        return new Car(carIds.get(index), licensePlates.get(index), color.get(index),
                model.get(index), brand.get(index), year.get(index));
    }


}
