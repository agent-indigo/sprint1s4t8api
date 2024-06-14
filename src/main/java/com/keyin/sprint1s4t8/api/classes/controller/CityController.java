package com.keyin.sprint1s4t8.api.classes.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin

public class CityController {

    // Just for testing if it works in a proper way

    // path: http://localhost:8080/montreal
    @GetMapping("/montreal")
    public String city(){
        return "montreal";
    }
}
