package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
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
}