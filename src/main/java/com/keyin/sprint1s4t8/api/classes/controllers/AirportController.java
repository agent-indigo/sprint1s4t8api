package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.api.classes.services.AirportService;
@RestController
@CrossOrigin
public final class AirportController {
    @Autowired
    private AirportService airportService;
    public AirportController() {
        this.airportService = new AirportService();
    }
    @GetMapping("/airports")
    public List<AirportModel> list() {
        return airportService.list();
    }
    @GetMapping("/airports/{id}")
    public AirportModel show(@PathVariable int id) {
        return airportService.show(id);
    }
    @PostMapping("/airports")
    public String add(@RequestBody AirportModel airportModel) {
        return airportService.add(airportModel);
    }
    @PutMapping("/airports/{id}")
    public String edit(
        @PathVariable int id,
        @RequestBody AirportModel update
    ) {
        return airportService.edit(id, update);
    }
    @DeleteMapping("/airports/{id}")
    public String delete(@PathVariable int id) {
        return airportService.delete(id);
    }
    @GetMapping("/airports/{id}/aircraft")
    public List<AircraftModel> getPlanes(@PathVariable int id) {
        return airportService.getPlanes(id);
    }
    @PostMapping("/airports/{id}/aircraft")
    public String addPlane(
        @PathVariable int id,
        @RequestBody AircraftModel aircraft
    ) {
        return airportService.addPlane(id, aircraft);
    }
    @DeleteMapping("/airports/{id}/aircraft/{index}")
    public String deletePlane(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return airportService.deletePlane(id, index);
    }
    @GetMapping("/airports/{id}/passengers")
    public List<PassengerModel> getPassengers(@PathVariable int id) {
        return airportService.getPassengers(id);
    }
    @PostMapping("/airports/{id}/passengers")
    public String addPassenger(
        @PathVariable int id,
        @RequestBody PassengerModel passenger
    ) {
        return airportService.addPassenger(id, passenger);
    }
    @DeleteMapping("/airports/{id}/passengers/{index}")
    public String deletePassenger(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return airportService.deletePassenger(id, index);
    }
}