package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AircraftModel;
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
}