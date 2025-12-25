package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService ser;

    @PostMapping("/vehicles")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return ser.createVehicle(vehicle);
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return ser.getVehicleById(id);
    }

    @GetMapping("/vehicles/vin/{vin}")
    public Vehicle getVehicleByVin(@PathVariable String vin) {
        return ser.getVehicleByVin(vin);
    }

    @GetMapping("/vehicles/owner/{ownerId}")
    public List<Vehicle> getVehicleByOwner(@PathVariable Long ownerId) {
        return ser.getVehicleByOwner(ownerId);
    }

    @PutMapping("/vehicles/deactivate/{id}")
    public String deactivateVehicle(@PathVariable Long id) {
        ser.deactivateVehicle(id);
        return "Vehicle deactivated successfully";
    }
}
