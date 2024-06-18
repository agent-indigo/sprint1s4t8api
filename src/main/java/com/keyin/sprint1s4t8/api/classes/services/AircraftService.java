
package com.keyin.sprint1s4t8.api.classes.services;

import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AircraftService {
    private final List<AircraftModel> aircrafts = new ArrayList<>();

    public AircraftService() {}

    public AircraftModel createAircraft(int id, String model, String airline, int capacity) {
        AircraftModel aircraftModel = new AircraftModel(id, model, airline, capacity);
        aircrafts.add(aircraftModel);
        return aircraftModel;
    }

    public List<AircraftModel> getAllAircrafts() {
        return new ArrayList<>(aircrafts);
    }

    public Optional<AircraftModel> getAircraftById(int id) {
        return aircrafts.stream().filter(a -> a.getId() == id).findFirst();
    }

    public boolean updateAircraft(int id, String model, String airline, int capacity) {
        Optional<AircraftModel> optionalAircraft = getAircraftById(id);
        if (optionalAircraft.isPresent()) {
            AircraftModel aircraft = optionalAircraft.get();
            aircraft.setModel(model);
            aircraft.setAirline(airline);
            aircraft.setCapacity(capacity);
            return true;
        }
        return false;
    }

    public boolean deleteAircraft(int id) {
        return aircrafts.removeIf(a -> a.getId() == id);
    }
}
