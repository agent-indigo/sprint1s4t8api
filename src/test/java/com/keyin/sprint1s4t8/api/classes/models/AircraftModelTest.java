
package com.keyin.sprint1s4t8.api.classes.models;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public final class AircraftModelTest {

    private ArrayList<AircraftModel> aircraftModels;
    private AircraftModel aircraftModel;
    public AircraftModelTest() {
        this.aircraftModels = new ArrayList<>();
        this.aircraftModel = new AircraftModel();
    }

    @Test
    public void testCreate() {
        aircraftModel.setId(1);
        aircraftModel.setModel("Boeing 747");
        aircraftModel.setAirline("WestJet");
        aircraftModel.setCapacity(200);
        aircraftModels.add(aircraftModel);
        Assertions.assertEquals(1, aircraftModels.size());
    }

    @Test
    public void testAddAllowedAirport() {
        AirportModel airport = new AirportModel(1, "YYZ", "Toronto Pearson", new CityModel());
        aircraftModel.addAllowedAirport(airport);
        Assertions.assertEquals(1, aircraftModel.getAllowedAirports().size());
    }

    @Test
    public void testAddPassenger() {
        PassengerModel passenger = new PassengerModel(1, "John", "Doe", "123-456-7890", new CityModel());
        aircraftModel.addPassenger(passenger);
        Assertions.assertEquals(1, aircraftModel.getPassengers().size());
    }
}