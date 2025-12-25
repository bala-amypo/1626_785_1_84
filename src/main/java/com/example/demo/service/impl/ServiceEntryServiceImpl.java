package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ServiceEntry;
import com.example.demo.entity.Vehicle;
import com.example.demo.entity.Garage;

import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.GarageRepository;

import com.example.demo.service.ServiceEntryService;

import com.example.demo.exception.FutureServiceDateException;
import com.example.demo.exception.OdometerValidationException;
import com.example.demo.exception.InactiveVehicleException;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository s;
    private final VehicleRepository v;
    private final GarageRepository g;

    public ServiceEntryServiceImpl(ServiceEntryRepository s, VehicleRepository v, GarageRepository g) {
        this.s = s;
        this.v = v;
        this.g = g;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        if (entry == null || entry.getVehicle() == null || entry.getVehicle().getId() == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }
        if (entry.getGarage() == null || entry.getGarage().getId() == null) {
            throw new EntityNotFoundException("Garage not found");
        }

        Vehicle vehicle = v.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = g.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (vehicle.getActive() != null && vehicle.getActive().equals(false)) {
            throw new InactiveVehicleException("Only active vehicles allowed");
        }

        if (entry.getServiceDate() != null && entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new FutureServiceDateException("Service date cannot be future");
        }

        Optional<ServiceEntry> last = s.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
        if (last.isPresent() && entry.getOdometerReading() != null) {
            Integer lastOdo = last.get().getOdometerReading();
            if (lastOdo != null && entry.getOdometerReading() < lastOdo) {
                throw new OdometerValidationException("Odometer reading must be >=");
            }
        }

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return s.save(entry);
    }

    @Override
    public ServiceEntry getEntryById(Long id) {
        return s.findById(id).orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return s.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getEntriesByGarage(Long garageId) {
        return s.findByGarageId(garageId);
    }
}
