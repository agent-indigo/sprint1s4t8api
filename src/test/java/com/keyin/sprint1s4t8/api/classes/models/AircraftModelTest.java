package com.keyin.sprint1s4t8.api.classes.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AircraftModelTest {
    @Test
    public void testAircraftCreate(){
        // Create a new Aircraft object
        // Aircraft aircraft1 = new Aircraft("Construtor values")
        //AircraftModel aircraftModel = new AircraftModel()

        //Check to see if the aircraft is created?
        // Add the new aircraft to a list
        // ArrayList<AircaftModel> aircrafts = new ArrayList<AircraftModel>()
        // aircraft.add(aircraftModel)

        // Check the list to see if the aircraft object is there...

        // if(aircraftModels.size == 1){
        ArrayList<AircraftModel> aircraftModels = new ArrayList<>();

        AircraftModel aircraftModel = new AircraftModel(1,"Model Test","West Jet",200);
        aircraftModels.add(aircraftModel);

        Assertions.assertEquals(1, aircraftModels.size());
    }

    // Test The edit of an aircraft

    //


}
