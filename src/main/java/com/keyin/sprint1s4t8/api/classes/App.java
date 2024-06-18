package com.keyin.sprint1s4t8.api.classes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {
    "com.keyin.sprint1s4t8.api.classes.controllers",
    "com.keyin.sprint1s4t8.api.classes.models",
    "com.keyin.sprint1s4t8.api.classes.services"
})
public class App {
    public static void main (String[] args) {
        SpringApplication.run(App.class, args);
    }
}