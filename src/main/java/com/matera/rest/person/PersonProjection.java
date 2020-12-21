package com.matera.rest.person;

import java.time.LocalDate;
import java.util.Date;

public interface PersonProjection {

    Long getTaxId();

    String getFirstName();

    String getLastName();

    String getCity();

    LocalDate getBirthDate();

}
