

package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository entryRepo;
    private final VehicleRepository vehicleRepo;
    private final GarageRepository garageRepo;

    public ServiceEntryServiceImpl(ServiceEntryRepository entryRepo,
                                   VehicleRepository vehicleRepo,
                                   GarageRepository garageRepo) {
        this.entryRepo = entryRepo;
        this.vehicleRepo = vehicleRepo;
        this.garageRepo = garageRepo;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        if (entry == null || entry.getVehicle() == null || entry.getVehicle().getId() == null) {
            throw new IllegalArgumentException("Vehicle not found");
        }
        if (entry.getGarage() == null || entry.getGarage().getId() == null) {
            throw new IllegalArgumentException("Garage not found");
        }

        Vehicle vehicle = vehicleRepo.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = garageRepo.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        // ✅ FIXED: correct Lombok getter
        if (vehicle.getIsactive() != null && !vehicle.getIsactive()) {
            throw new IllegalArgumentException("Vehicle is inactive");
        }

        if (garage.getActive() != null && !garage.getActive()) {
            throw new IllegalArgumentException("Garage is inactive");
        }

        if (entry.getServiceDate() != null && entry.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Service date cannot be in the future");
        }

        if (entry.getOdometerReading() != null) {
            ServiceEntry last = entryRepo.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
            if (last != null && last.getOdometerReading() != null
                    && entry.getOdometerReading() < last.getOdometerReading()) {
                throw new IllegalArgumentException("Odometer reading must be increasing");
            }
        }

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return entryRepo.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return entryRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service entry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return entryRepo.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getEntriesByGarage(Long garageId) {
        return entryRepo.findByGarageId(garageId);
    }
}
