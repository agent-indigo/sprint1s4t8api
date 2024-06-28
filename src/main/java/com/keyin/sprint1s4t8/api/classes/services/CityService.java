package com.keyin.sprint1s4t8.api.classes.services;
import com.keyin.sprint1s4t8.api.classes.abstracts.RouteService;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.CityModel;
import org.springframework.stereotype.Service;
import org.springframework.web.server.MethodNotAllowedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public final class CityService extends RouteService {
    private CityModel city;
    private Map<Integer, CityModel> cities;
    public CityService() {
        super("City");
        this.cities = new HashMap<Integer, CityModel>();
    }
    public List<CityModel> list() {
        return List.copyOf(cities.values());
    }
    public CityModel show(int id) {
        return cities.get(id);
    }
    public String add(CityModel city) {
        try {
            cities.put(cities.size() + 1, city);
            return s201msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public String edit(
        int id,
        CityModel update
    ) {
        try {
            cities.put(id, update);
            return s200msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    @Override
    public String delete(int id) {
        try {
            cities.remove(id);
            return s204msg;
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
    public List<AirportModel> getAirports(int id) {
        this.city = cities.get(id);
        return city != null ? city.getAirports() : null;
    }
    public String addAirport(
        int id,
        AirportModel airport
    ) {
        try {
            this.city = cities.get(id);
            if (city != null) {
                city.addAirport(airport);
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
            this.city = cities.get(id);
            if (city != null) {
                city.deleteAirport(index);
                return s204msg;
            } else {
                return e404msg;
            }
        } catch (MethodNotAllowedException methodNotAllowedException) {
            return methodNotAllowedException.getStackTrace().toString();
        }
    }
}