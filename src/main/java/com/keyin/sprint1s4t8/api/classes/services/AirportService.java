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
public final class AirportService extends RouteService {
    private AirportModel airport;
    private Map<Integer, AirportModel> airports;
    public AirportService() {
        super("Airport");
        this.airports = new HashMap<Integer, AirportModel>();
    }
    public List<AirportModel> list() {
        return List.copyOf(airports.values());
    }
    public AirportModel show(int id) {
        return airports.get(id);
    }
    public String add(AirportModel airport) {
        airports.put(airports.size() + 1, airport);
        return s201msg;
    }
    public String edit(
        int id,
        AirportModel update
    ) {
        try {
            airports.put(id, update);
            return s200msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String delete(int id) {
        try {
            airports.remove(id);
            return s204msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<AircraftModel> getPlanes(int id) {
        this.airport = airports.get(id);
        return airport != null ? airport.getPlanes() : null;
    }
    public String addPlane(
        int id,
        AircraftModel plane
    ) {
        try {
            this.airport = airports.get(id);
            if (airport != null) {
                airport.deletePlane(id);
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
            this.airport = airports.get(id);
            if (airport != null) {
                airport.deletePlane(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<PassengerModel> getPassengers(int id) {
        this.airport = airports.get(id);
        return airport != null ? airport.getPassengers() : null;
    }
    public String addPassenger(
        int id,
        PassengerModel passenger
    ) {
        try {
            this.airport = airports.get(id);
            if (airport != null) {
                airport.addPassenger(passenger);
                return s201msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String deletePassenger(
        int id,
        int index
    ) {
        try {
            this.airport = airports.get(id);
            if (airport != null) {
                airport.deletePassenger(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}