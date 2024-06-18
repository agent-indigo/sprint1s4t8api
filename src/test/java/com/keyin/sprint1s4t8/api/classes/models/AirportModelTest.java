package com.keyin.sprint1s4t8.api.classes.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AirportModelTest {

    @Test
    public void testAirportModelTest(){

        ArrayList<AirportModel> airportModels = new ArrayList<>();

        AirportModel airportModel = new AirportModel();
        airportModel.setId(1);
        airportModel.setCode("YYT");
        airportModel.setName("St.Johns");
        airportModels.add(airportModel);

        Assertions.assertEquals(1, airportModels.size());
    }

}