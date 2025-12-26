package com.example.demo.service;

import com.example.demo.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle v);
    Vehicle getVehicleById(Long id);
    List<Vehicle> getVehiclesByOwner(Long ownerId);
    void deactivateVehicle(Long id);
    Vehicle getVehicleByVin(String vin);
}
