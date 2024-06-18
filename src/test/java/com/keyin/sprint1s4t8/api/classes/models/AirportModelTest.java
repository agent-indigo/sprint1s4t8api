package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public final class AirportModelTest {
    private ArrayList<AirportModel> airportModels;
    private AirportModel airportModel;
    public AirportModelTest() {
        this.airportModels = new ArrayList<AirportModel>();
        this.airportModel = new AirportModel();
    }
    @Test
    public void testAirportModelTest(){
        airportModel.setId(1);
        airportModel.setCode("YYT");
        airportModel.setName("St.Johns");
        airportModels.add(airportModel);
        Assertions.assertEquals(1, airportModels.size());
    }
}