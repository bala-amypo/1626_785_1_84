package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController

public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping("/POST GARAGE")
    public Garage createGarage(@RequestBody Garage garage) {
        return garageService.createGarage(garage);
    }

    @GetMapping("/GET{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @GetMapping ("GETALL")
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }

    @PutMapping("/PUTGarage")
    public Garage deactivateGarage(@PathVariable Long id) {
        return garageService.deactivateGarage(id);
    }
}
