package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.PassengerModel;
import com.keyin.sprint1s4t8.api.classes.services.PassengerService;
@RestController
@CrossOrigin
public final class PassengerController {
    @Autowired
    private PassengerService passengerService;
    public PassengerController() {
        this.passengerService = new PassengerService();
    }
    @GetMapping("/passengers")
    private List<PassengerModel> list() {
        return passengerService.list();
    }
    @GetMapping("/passengers/{id}")
    private PassengerModel show(@PathVariable int id) {
        return passengerService.show(id);
    }
    @PostMapping("/passengers")
    private String add(@RequestBody PassengerModel passenger) {
        return passengerService.add(passenger);
    }
    @PutMapping("/passengers/{id}")
    private String edit(
        @PathVariable int id,
        @RequestBody PassengerModel update
    ) {
        return passengerService.edit(id, update);
    }
    @DeleteMapping("/passengers/{id}")
    public String delete(@PathVariable int id) {
        return passengerService.delete(id);
    }
    @GetMapping("/passengers/{id}/aircraft")
    public List<AircraftModel> getPlanes(@PathVariable int id) {
        return passengerService.getPlanes(id);
    }
    @PostMapping("/passengers/{id}/aircraft")
    public String addPlane(
        @PathVariable int id,
        @RequestBody AircraftModel aircraft
    ) {
        return passengerService.addPlane(id, aircraft);
    }
    @DeleteMapping("/passengers/{id}/aircraft/{index}")
    public String deletePlane(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return passengerService.deletePlane(id, index);
    }
    @GetMapping("/passengers/{id}/airports")
    public List<AirportModel> getAirports(@PathVariable int id) {
        return passengerService.getAirports(id);
    }
    @PostMapping("/passengers/{id}/airports")
    public String addAirport(
        @PathVariable int id,
        @RequestBody AirportModel airport
    ) {
        return passengerService.addAirport(id, airport);
    }
    @DeleteMapping("/passengers/{id}/airports/{index}")
    public String deleteAirport(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return passengerService.deleteAirport(id, index);
    }
}