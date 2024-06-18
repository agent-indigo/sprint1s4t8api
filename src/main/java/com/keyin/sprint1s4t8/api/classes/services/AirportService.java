package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class AirportService {
    private Map<Integer, AirportModel> airportMap;
    public AirportService() {
        this.airportMap = new HashMap<Integer, AirportModel>();
    }
    public List<AirportModel> list() {
        return List.copyOf(airportMap.values());
    }
    public AirportModel show(int id) {
        return airportMap.get(id);
    }
    public String add(AirportModel airport) {
        airportMap.put(airportMap.size() + 1, airport);
        return "Airport successfully added.";
    }
    public String edit(
        int id,
        AirportModel update
    ) {
        try {
            airportMap.put(id, update);
            return "Airport successfully updated.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String delete(int id) {
        try {
            airportMap.remove(id);
            return "Airport successfully deleted.";
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}