package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.exception.DuplicateVinException;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository v;

    public VehicleServiceImpl(VehicleRepository v) {
        this.v = v;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        Optional<Vehicle> existing = v.findByVin(vehicle.getVin());
        if (existing.isPresent()) {
            throw new DuplicateVinException("VIN already exists");
        }

        if (vehicle.getIsactive() == null) {
            vehicle.setIsactive(true);
        }

        return v.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return v.findById(id).orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        return v.findByVin(vin).orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getVehicleByOwner(Long ownerId) {
        return v.findByOwnerId(ownerId);
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setIsactive(false);
        v.save(vehicle);
    }
}
