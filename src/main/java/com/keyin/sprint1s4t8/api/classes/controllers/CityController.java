package com.keyin.sprint1s4t8.api.classes.controllers;
import com.keyin.sprint1s4t8.api.classes.models.AirportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/cities/addAirport/{id}")
    public ResponseEntity<?> addAirportsToCity(@PathVariable int id, @RequestBody AirportModel airportModel){
        List<CityModel> cityModels = cityService.searchCityById(id);
        for(CityModel cityModel: cityModels)
            if(cityModel.getId() == id){
                cityModel.addAirportToCitys(airportModel);
            } else {
                throw new Error("City With Id Not Found");
            }
        return  new ResponseEntity<>("Airport Model Was Added To The City", HttpStatus.OK);
    }

    @GetMapping("/cities/getAirports/{id}")
    public List<AirportModel> getAirportsInCity(@PathVariable int id){
        List<CityModel> tempCitys = cityService.searchCityById(id);
        for(CityModel cityModel: tempCitys)
            if(cityModel.getId() == id){
                return  cityModel.getAirportModelList();
            }
        throw  new RuntimeException(("City Is Not Found Please Enter A Vaild City"));

    }
}