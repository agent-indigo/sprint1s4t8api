package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.api.classes.services.AircraftService;
@RestController
@CrossOrigin
public final class AircraftController {
    @Autowired
    private AircraftService aircraftService;
    public AircraftController() {
        this.aircraftService = new AircraftService();
    }
    @GetMapping("/aircraft")
    public List<AircraftModel> list() {
        return aircraftService.list();
    }
    @GetMapping("/aircraft/{id}")
    public AircraftModel show(@PathVariable int id) {
        return aircraftService.show(id);
    }
    @PostMapping("/aircraft")
    public String add(@RequestBody AircraftModel aircraft) {
        return aircraftService.add(aircraft);
    }
    @PutMapping("/aircraft/{id}")
    public String edit(
        @PathVariable int id,
        @RequestBody AircraftModel aircraft
    ) {
        return aircraftService.edit(id, aircraft);
    }
    @DeleteMapping("/aircraft/{id}")
    public String delete(@PathVariable int id) {
        return aircraftService.delete(id);
    }
    @GetMapping("/aircraft/{id}/airports")
    public List<AirportModel> getAirports(@PathVariable int id) {
        return aircraftService.getAirports(id);
    }
    @PostMapping("/aircraft/{id}/airports")
    public String addAirport(
        @PathVariable int id,
        @RequestBody AirportModel airport
    ) {
        return aircraftService.addAirport(id, airport);
    }
    @DeleteMapping("/aircraft/{id}/airports/{index}")
    public String deleteAirport(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return aircraftService.deleteAirport(id, index);
    }
    @GetMapping("/aircraft/{id}/passengers")
    public List<PassengerModel> getPassengers(@PathVariable int id) {
        return aircraftService.getPassengers(id);
    }
    @PostMapping("/aircraft/{id}/passengers")
    public String addPassenger(
        @PathVariable int id,
        @RequestBody PassengerModel passenger
    ) {
        return aircraftService.addPassenger(id, passenger);
    }
    @DeleteMapping("/aircraft/{id}/passengers/{index}")
    public String deletePassenger(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return aircraftService.deletePassenger(id, index);
    }
}