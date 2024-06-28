package com.keyin.sprint1s4t8.api.classes.services;
import org.springframework.stereotype.Service;
import com.keyin.sprint1s4t8.api.classes.abstracts.RouteService;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class AircraftService extends RouteService {
    private AircraftModel plane;
    private Map<Integer, AircraftModel> planes;
    public AircraftService() {
        super("Aircraft");
        this.planes = new HashMap<Integer, AircraftModel>();
    }
    public List<AircraftModel> list() {
        return List.copyOf(planes.values());
    }
    public AircraftModel show(int id) {
        return planes.get(id);
    }
    public String add(AircraftModel plane) {
        try {
            planes.put(planes.size() + 1, plane);
            return s201msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String edit(
        int id,
        AircraftModel update
    ) {
        try {
            planes.put(id, update);
            return s200msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    @Override
    public String delete(int id) {
        try {
            planes.remove(id);
            return s204msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<AirportModel> getAirports(int id) {
        this.plane = planes.get(id);
        return plane != null ? plane.getAirports() : null;
    }
    public String addAirport(
        int id, 
        AirportModel airport
    ) {
        try {
            this.plane = planes.get(id);
            if (plane != null) {
                plane.addAirport(airport);
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
            this.plane = planes.get(id);
            if (plane != null) {
                plane.deleteAirport(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<PassengerModel> getPassengers(int id) {
        this.plane = planes.get(id);
        return plane != null ? plane.getPassengers() : null;
    }
    public String addPassenger(
        int id,
        PassengerModel passenger
    ) {
        try {
            this.plane = planes.get(id);
            if (plane != null) {
                plane.addPassenger(passenger);
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
            this.plane = planes.get(id);
            if (plane != null) {
                plane.deletePassenger(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}