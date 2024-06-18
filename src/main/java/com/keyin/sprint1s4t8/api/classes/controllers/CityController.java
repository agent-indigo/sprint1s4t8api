package com.keyin.sprint1s4t8.api.classes.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
    @GetMapping("/cities/{index}")
    public CityModel show(@PathVariable int index) {
        return cityService.show(index);
    }
    @PostMapping("/cities")
    public String add(@RequestBody CityModel city) {
        return cityService.add(city);
    }
    @PutMapping("/cities/{index}")
    public String edit(
        @PathVariable int index,
        @RequestBody CityModel city
    ) {
        return cityService.edit(index, city);
    }
    @DeleteMapping("cities/{index}")
    public String delete(@PathVariable int index) {
        return cityService.delete(index);
    }
}