package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import com.keyin.sprint1s4t8.api.classes.models.CityModel;
import com.keyin.sprint1s4t8.api.classes.services.CityService;
@RestController
@CrossOrigin
public final class CityController {
    @Autowired
    private CityService cityService;
    public CityController() {
        this.cityService = new CityService();
    }
    @GetMapping("/cities")
    public List<CityModel> list() {
        return cityService.list();
    }
    @GetMapping("/cities/{id}")
    public CityModel show(@PathVariable int id) {
        return cityService.show(id);
    }
    @PostMapping("/cities")
    public String add(@RequestBody CityModel city) {
        return cityService.add(city);
    }
    @PutMapping("/cities/{id}")
    public String edit(
        @PathVariable int id,
        @RequestBody CityModel city
    ) {
        return cityService.edit(id, city);
    }
    @DeleteMapping("/cities/{id}")
    public String delete(@PathVariable int id) {
        return cityService.delete(id);
    }
    @GetMapping("/cities/{id}/airports")
    public List<AirportModel> getAirports(@PathVariable int id) {
        return cityService.getAirports(id);
    }
    @PostMapping("/cities/{id}/airports")
    public String addAirport(
        @PathVariable int id,
        @RequestBody AirportModel airport
    ) {
        return cityService.addAirport(id, airport);
    }
    @DeleteMapping("/cities/{id}/airports/{index}")
    public String deleteAirport(
        @PathVariable int id,
        @PathVariable int index
    ) {
        return cityService.deleteAirport(id, index);
    }
}