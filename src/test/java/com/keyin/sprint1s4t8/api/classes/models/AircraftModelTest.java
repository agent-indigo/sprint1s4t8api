//AircraftModelTest
package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public final class AircraftModelTest {
    private ArrayList<AircraftModel> aircraftModels;
    private AircraftModel aircraftModel;
    public AircraftModelTest() {
        this.aircraftModels = new ArrayList<AircraftModel>();
        this.aircraftModel = new AircraftModel();
    }
    @Test
    public void testAircraftCreate() {
        aircraftModel.setId(1);
        aircraftModel.setModel("Boeing 747");
        aircraftModel.setAirline("WestJet");
        aircraftModel.setCapacity(200);
        aircraftModels.add(aircraftModel);
        Assertions.assertEquals(1, aircraftModels.size());
    }
}