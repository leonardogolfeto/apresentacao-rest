package com.matera.rest.config;

import com.matera.rest.person.Person;
import com.matera.rest.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class PersonConfig {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    private void init(){
        for(int i = 0; i<10; i++){
            personRepository.save(getPerson(i));
        }
    }

    private Person getPerson(int index) {

        List<Long> taxIds = Arrays.asList(11130913988L,
                17600659000L,
                10508510058L,
                83905087022L,
                52557200034L,
                23511361010L,
                42908466023L,
                51126319023L,
                13735125042L,
                82132300003L);

        List<String> names = Arrays.asList("Leonardo",
                "Leonel",
                "Joao",
                "Maria",
                "Tiao",
                "Marcelo",
                "Francisco",
                "Mariana",
                "Gabriel",
                "Caio");

        List<String> lastNames = Arrays.asList("Golfeto",
                "Tasso",
                "Nakamura",
                "Cuesta",
                "Seabra",
                "Megumi",
                "Oswaldo",
                "Pena",
                "Dos Anjos",
                "Dos Santos");

        List<String> citys = Arrays.asList("Maringa",
                "Campinas",
                "Porto Alegre",
                "Canada",
                "Sao Paulo",
                "Curitiba",
                "Cambe",
                "Jandaia do Sul",
                "Marialva",
                "Mandaguari");

        return new Person(taxIds.get(index),
                            names.get(index),
                            lastNames.get(index),
                            citys.get(index),
                            LocalDate.now());

    }

}
