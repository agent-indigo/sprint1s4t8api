package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.abstracts.RouteService;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class PassengerService extends RouteService {
    private PassengerModel passenger;
    private Map<Integer, PassengerModel> passengers;
    public PassengerService() {
        super("Passenger");
        this.passengers = new HashMap<Integer, PassengerModel>();
    }
    public List<PassengerModel> list() {
        return List.copyOf(passengers.values());
    }
    public PassengerModel show(int id) {
        return passengers.get(id);
    }
    public String add(PassengerModel passenger) {
        try {
            passengers.put(passengers.size() + 1, passenger);
            return s201msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String edit(
        int id,
        PassengerModel update
    ) {
        try {
            passengers.put(id, update);
            return s200msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String delete(int id) {
        try {
            passengers.remove(id);
            return s204msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<AircraftModel> getPlanes(int id) {
        this.passenger = passengers.get(id);
        return passenger != null ? passenger.getPlanes() : null;
    }
    public String addPlane(
        int id,
        AircraftModel aircraft
    ) {
        try {
            this.passenger = passengers.get(id);
            if (passenger != null) {
                passenger.addPlane(aircraft);
                return s201msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String deletePlane(
        int id,
        int index
    ) {
        try {
            this.passenger = passengers.get(id);
            if (passenger != null) {
                passenger.deletePlane(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<AirportModel> getAirports(int id) {
        this.passenger = passengers.get(id);
        return passenger != null ? passenger.getAirports() : null;
    }
    public String addAirport(
        int id,
        AirportModel airport
    ) {
        try {
            this.passenger = passengers.get(id);
            if (passenger != null) {
                passenger.addAirport(airport);
                return s201msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String deleteAirport(
        int id,
        int index
    ) {
        try {
            this.passenger = passengers.get(id);
            if (passenger != null) {
                passenger.deleteAirport(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}