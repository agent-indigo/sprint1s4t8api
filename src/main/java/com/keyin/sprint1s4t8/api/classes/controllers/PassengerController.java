//PassengerController
package com.keyin.sprint1s4t8.api.classes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
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
    private String edit(@PathVariable int id, @RequestBody PassengerModel update) {
        return passengerService.edit(id, update);
    }

    @DeleteMapping("/passengers/{id}")
    public String delete(@PathVariable int id) {
        return passengerService.delete(id);
    }

    @PostMapping("/passengers/{passengerId}/aircrafts")
    public String addAircraftToPassenger(@PathVariable int passengerId, @RequestBody AircraftModel aircraft) {
        return passengerService.addAircraftToPassenger(passengerId, aircraft);
    }

    @GetMapping("/passengers/{passengerId}/aircrafts")
    public List<AircraftModel> getAircraftsByPassenger(@PathVariable int passengerId) {
        return passengerService.getAircraftsByPassenger(passengerId);
    }
}
