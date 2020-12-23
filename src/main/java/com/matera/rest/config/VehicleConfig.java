package com.matera.rest.config;

import com.matera.rest.vehicle.Vehicle;
import com.matera.rest.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Configuration
public class VehicleConfig {

    @Autowired
    private VehicleRepository vehicleRepository;

    @PostConstruct
    private void init(){
        for(int i = 0; i<10; i++){
            vehicleRepository.save(getVehicle(i));
        }
    }

    private Vehicle getVehicle(int index) {

        List<String> licensePlates = Arrays.asList(
                "DTX5782",
                "HPM0681",
                "DZK4257",
                "MMN4164",
                "MZK2962",
                "JVQ6238",
                "DLQ8684",
                "MZZ1922",
                "IQB1036",
                "GEG5192");

        List<String> models = Arrays.asList(
                "Onix",
                "Gol",
                "Uno",
                "Palio",
                "CrossFox",
                "Siena",
                "Celta",
                "Voyage",
                "HB20",
                "Corsa");

        List<String> brands = Arrays.asList(
                "General Motors",
                "Volkswagen",
                "Fiat",
                "Fiat",
                "Volkswagen",
                "Fiat",
                "General Motors",
                "Volkswagen",
                "Hyundai",
                "General Motors");

        List<String> colors = Arrays.asList(
                "Azul",
                "Prata",
                "Preto",
                "Vermelho",
                "Prata",
                "Amarelo",
                "Preto",
                "Vermelho",
                "Prata",
                "Amarelo");

        List<Integer> years = Arrays.asList(
                2007,
                2008,
                2009,
                2010,
                2011,
                2012,
                2013,
                2014,
                2015,
                2016);

        return new Vehicle(
                licensePlates.get(index),
                models.get(index),
                brands.get(index),
                colors.get(index),
                years.get(index)
        );

    }

}
