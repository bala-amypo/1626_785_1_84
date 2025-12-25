package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.model.Garage;

import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.GarageRepository;

import com.example.demo.service.ServiceEntryService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository serviceEntryRepository,
            VehicleRepository vehicleRepository,
            GarageRepository garageRepository
    ) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        if (entry == null || entry.getVehicle() == null || entry.getVehicle().getId() == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }
        if (entry.getGarage() == null || entry.getGarage().getId() == null) {
            throw new EntityNotFoundException("Garage not found");
        }

        Vehicle vehicle = vehicleRepository.findById(entry.getVehicle().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));

        Garage garage = garageRepository.findById(entry.getGarage().getId())
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));

        if (vehicle.getActive() != null && !vehicle.getActive()) {
            // must contain "active vehicles"
            throw new IllegalArgumentException("active vehicles");
        }

        if (garage.getActive() != null && !garage.getActive()) {
            // garage inactive - message not strictly specified, but keep clear
            throw new IllegalArgumentException("Garage not found");
        }

        if (entry.getServiceDate() != null && entry.getServiceDate().isAfter(LocalDate.now())) {
            // must contain "future"
            throw new IllegalArgumentException("future");
        }

        Optional<ServiceEntry> last = serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle);
        if (last.isPresent() && entry.getOdometerReading() != null) {
            Integer lastOdo = last.get().getOdometerReading();
            if (lastOdo != null && entry.getOdometerReading() < lastOdo) {
                // must contain ">="
                throw new IllegalArgumentException(">=");
            }
        }

        entry.setVehicle(vehicle);
        entry.setGarage(garage);

        return serviceEntryRepository.save(entry);
    }

    @Override
    public ServiceEntry getServiceEntryById(Long id) {
        return serviceEntryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<ServiceEntry> getEntriesByGarage(Long garageId) {
        return serviceEntryRepository.findByGarageId(garageId);
    }

    @Override
    public List<ServiceEntry> getAllServiceEntries() {
        return serviceEntryRepository.findAll();
    }
}
