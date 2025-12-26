package com.example.demo.controller;
import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/garages")
public class GarageController {
    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public ResponseEntity<Garage> createGarage(@Valid @RequestBody Garage g) {
        return ResponseEntity.ok(garageService.createGarage(g));
    }
}
