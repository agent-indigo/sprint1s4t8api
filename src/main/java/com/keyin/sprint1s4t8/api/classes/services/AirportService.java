
package com.keyin.sprint1s4t8.api.classes.services;

import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.CityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AirportService {
    private final List<AirportModel> airports = new ArrayList<>();

    public AirportService() {}

    public AirportModel createAirport(int id, String name, String code, CityModel city) {
        AirportModel airportModel = new AirportModel(id, name, code, city);
        airports.add(airportModel);
        return airportModel;
    }

    public List<AirportModel> getAllAirports() {
        return new ArrayList<>(airports);
    }

    public Optional<AirportModel> getAirportById(int id) {
        return airports.stream().filter(a -> a.getId() == id).findFirst();
    }

    public boolean updateAirport(int id, String name, String code, CityModel city) {
        Optional<AirportModel> optionalAirport = getAirportById(id);
        if (optionalAirport.isPresent()) {
            AirportModel airport = optionalAirport.get();
            airport.setName(name);
            airport.setCode(code);
            airport.setCity(city);
            return true;
        }
        return false;
    }

    public boolean deleteAirport(int id) {
        return airports.removeIf(a -> a.getId() == id);
    }
}
