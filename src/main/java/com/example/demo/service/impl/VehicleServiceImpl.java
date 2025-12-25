package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.VehicleService;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.exception.DuplicateVinException;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository v;

    public VehicleServiceImpl(VehicleRepository v) {
        this.v = v;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        Vehicle existing = v.findByVin(vehicle.getVin());
        if (existing != null) {
            throw new DuplicateVinException("Vehicle with VIN '" + vehicle.getVin() + "' already exists");
        }

        if (vehicle.getIsactive() == null) {
            vehicle.setIsactive(true);
        }

        return v.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return v.findById(id).orElse(null);
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return v.findByVin(vin);
    }

    @Override
    public List<Vehicle> getVehicleByOwner(Long ownerId) {
        return v.findAll();
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle vehicle = v.findById(id).orElse(null);
        if (vehicle != null) {
            vehicle.setIsactive(false);
            v.save(vehicle);
        }
    }
}
