package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    List<Vehicle> getVehicleByVin(String vin);

    List<Vehicle> getVehicleByOwner(Long ownerId);
    
    void deactivateVehicle(Long id);
}
