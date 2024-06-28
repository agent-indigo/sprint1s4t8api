
package com.keyin.sprint1s4t8.api.classes.models;
import com.keyin.sprint1s4t8.api.classes.abstracts.Model;
import java.util.ArrayList;
import java.util.List;

public final class AircraftModel extends Model {
    private String model;
    private String airline;
    private int capacity;
    private List<AirportModel> allowedAirports;
    private List<PassengerModel> passengers;

    public AircraftModel(int id, String model, String airline, int capacity) {

        super(id);
        this.model = model;
        this.airline = airline;
        this.capacity = capacity;
        this.allowedAirports = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public AircraftModel() {
        super();
        this.allowedAirports = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<AirportModel> getAllowedAirports() {
        return allowedAirports;
    }

    public void addAllowedAirport(AirportModel airport) {
        this.allowedAirports.add(airport);
    }

    public List<PassengerModel> getPassengers() {
        return passengers;
    }

    public void addPassenger(PassengerModel passenger) {
        this.passengers.add(passenger);
    }
}