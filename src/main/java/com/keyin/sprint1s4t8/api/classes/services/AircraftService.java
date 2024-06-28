
package com.keyin.sprint1s4t8.api.classes.services;
import org.springframework.stereotype.Service;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public final class AircraftService {
    private Map<Integer, AircraftModel> aircraftMap;
    public AircraftService() {
        this.aircraftMap = new HashMap<>();
    }

    public List<AircraftModel> list() {
        return List.copyOf(aircraftMap.values());
    }

    public AircraftModel show(int id) {
        return aircraftMap.get(id);
    }

    public String add(AircraftModel aircraft) {
        aircraftMap.put(aircraftMap.size() + 1, aircraft);
        return "Aircraft successfully added.";
    }

    public String edit(int id, AircraftModel update) {

        try {
            aircraftMap.put(id, update);
            return "Aircraft successfully updated.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }

    public String delete(int id) {
        try {
            aircraftMap.remove(id);
            return "Aircraft successfully deleted.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }

    public String addAirportToAircraft(int aircraftId, AirportModel airport) {
        AircraftModel aircraft = aircraftMap.get(aircraftId);
        if (aircraft != null) {
            aircraft.addAllowedAirport(airport);
            return "Airport added to aircraft.";
        } else {
            return "Aircraft not found.";
        }
    }

    public String addPassengerToAircraft(int aircraftId, PassengerModel passenger) {
        AircraftModel aircraft = aircraftMap.get(aircraftId);
        if (aircraft != null) {
            aircraft.addPassenger(passenger);
            return "Passenger added to aircraft.";
        } else {
            return "Aircraft not found.";
        }
    }
}