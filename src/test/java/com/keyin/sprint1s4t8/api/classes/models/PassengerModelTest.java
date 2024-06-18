package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.keyin.sprint1s4t8.api.enums.ProvTerrCode;
public final class PassengerModelTest {
    private CityModel city;
    private PassengerModel passenger;
    public PassengerModelTest() {
        this.city = new CityModel();
        this.passenger = new PassengerModel();
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
        Assertions.assertEquals(1, passenger.getId());
        Assertions.assertEquals("Piers", passenger.getFirst());
        Assertions.assertEquals("Anthony", passenger.getLast());
        Assertions.assertEquals("555-555-5555", passenger.getPhone());
        Assertions.assertEquals(city, passenger.getCity());
    }
}