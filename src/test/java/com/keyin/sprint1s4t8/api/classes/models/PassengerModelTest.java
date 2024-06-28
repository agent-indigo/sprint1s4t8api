//PassengerModelTest
package com.keyin.sprint1s4t8.api.classes.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.keyin.sprint1s4t8.api.enums.ProvTerrCode;

import java.util.ArrayList;
import java.util.List;

public final class PassengerModelTest {
    private CityModel city;
    private PassengerModel passenger;
    private AircraftModel aircraft1;
    private AircraftModel aircraft2;

    public PassengerModelTest() {
        this.city = new CityModel();
        this.passenger = new PassengerModel();
        this.aircraft1 = new AircraftModel(1, "Boeing 737", "WestJet", 200);
        this.aircraft2 = new AircraftModel(2, "Airbus A320", "Air Canada", 180);
    }

    @Test
    public void testPassengerCreate() {
        city.setId(1);
        city.setName("Montreal");
        city.setProvince(ProvTerrCode.QC);
        passenger.setId(1);
        passenger.setFirst("Piers");
        passenger.setLast("Anthony");
        passenger.setPhone("555-555-5555");
        passenger.setCity(city);

        List<AircraftModel> aircraftList = new ArrayList<>();
        aircraftList.add(aircraft1);
        aircraftList.add(aircraft2);
        passenger.setAircrafts(aircraftList);

        Assertions.assertEquals(1, passenger.getId());
        Assertions.assertEquals("Piers", passenger.getFirst());
        Assertions.assertEquals("Anthony", passenger.getLast());
        Assertions.assertEquals("555-555-5555", passenger.getPhone());
        Assertions.assertEquals(city, passenger.getCity());
        Assertions.assertTrue(passenger.getAircrafts().contains(aircraft1));
        Assertions.assertTrue(passenger.getAircrafts().contains(aircraft2));
    }
}