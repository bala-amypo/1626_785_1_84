package com.example.demo.controller;
import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class GarageController {

    @Autowired
    private GarageService ser;

    @PostMapping("/garages")
    public Garage create(@RequestBody Garage garage) {
        return ser.createGarage(garage);
    }

    @PutMapping("/garages/{id}")
    public Garage update(@PathVariable Long id, @RequestBody Garage garage) {
        return ser.updateGarage(id, garage);
    }

    @GetMapping("/garages/{id}")
    public Garage getById(@PathVariable Long id) {
        return ser.getGarageById(id);
    }

    @GetMapping("/garages")
    public List<Garage> getAll() {
        return ser.getAllGarages();
    }

    @PutMapping("/garages/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        ser.deactivateGarage(id);
        return "Deactivated";
    }
}
