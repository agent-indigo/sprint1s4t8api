//AircraftModelTest
package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public final class AircraftModelTest {
    public AircraftModelTest() {}
    @Test
    public void testAircraftCreate() {
        ArrayList<AircraftModel> aircraftModels = new ArrayList<>();
        AircraftModel aircraftModel = new AircraftModel(1,"Model Test","West Jet",200);
        aircraftModels.add(aircraftModel);
        Assertions.assertEquals(1, aircraftModels.size());
    }
}