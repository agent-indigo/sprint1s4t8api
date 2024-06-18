//PassengerModelTest
package com.keyin.sprint1s4t8.api.classes.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassengerModelTest {
    @Test
    public void testPassengerCreate() {
        CityModel cityModel = new CityModel(1, "Montreal", ProvTerrCode.QC);
        PassengerModel passengerModel = new PassengerModel(1, "Piers", "Anthony", "123-456-7890", cityModel);

        Assertions.assertEquals(1, passengerModel.getId());
        Assertions.assertEquals("Piers", passengerModel.getFirst());
        Assertions.assertEquals("Anthony", passengerModel.getLast());
        Assertions.assertEquals("123-456-7890", passengerModel.getPhone());
        Assertions.assertEquals(cityModel, passengerModel.getCity());
    }

    @Test
    public void testPassengerEdit() {
        CityModel cityModel = new CityModel(1, "Montreal", ProvTerrCode.QC);
        PassengerModel passengerModel = new PassengerModel(1, "Piers", "Anthony", "123-456-7890", cityModel);

        passengerModel.setFirst("Danielle");
        passengerModel.setLast("Steel");
        passengerModel.setPhone("098-765-4321");
        CityModel newCityModel = new CityModel(2, "Toronto", ProvTerrCode.ON);
        passengerModel.setCity(newCityModel);

        Assertions.assertEquals("Danielle", passengerModel.getFirst());
        Assertions.assertEquals("Steel", passengerModel.getLast());
        Assertions.assertEquals("098-765-4321", passengerModel.getPhone());
        Assertions.assertEquals(newCityModel, passengerModel.getCity());
    }
}
