package com.matera.rest.config;

import com.matera.rest.vehicles.Vehicle;
import com.matera.rest.vehicles.VehicleRepository;
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

        List<Long> ids = Arrays.asList(11130913988L,
                17600659000L,
                10508510058L,
                83905087022L,
                52557200034L,
                23511361010L,
                42908466023L,
                51126319023L,
                13735125042L,
                82132300003L);

        List<String> plates = Arrays.asList("GYT-1067",
                "GIT-1031",
                "OVT-9532",
                "LVT-8533",
                "GVT-6534",
                "UVO-4535",
                "WYT-3536",
                "AVK-2537",
                "PVU-1538",
                "XPT-6539");

        List<String> brands = Arrays.asList("Nissan",
                "Toyota",
                "Chevrolet",
                "Audi",
                "Fiat",
                "Citroen",
                "Wolkswagen",
                "Honda",
                "Toyota",
                "Fiat");

        List<String> models = Arrays.asList("Uno",
                "Corolla",
                "Prisma",
                "A4",
                "Uno",
                "C3",
                "Gol",
                "Civic",
                "Etios",
                "Uno");

        List<String> colors = Arrays.asList("Red",
                "Green",
                "Blue",
                "Black",
                "Gray",
                "White",
                "Black",
                "Silver",
                "Black",
                "white");

        return new Vehicle(ids.get(index),
                plates.get(index),
                brands.get(index),
                models.get(index),
                colors.get(index));

    }

}
