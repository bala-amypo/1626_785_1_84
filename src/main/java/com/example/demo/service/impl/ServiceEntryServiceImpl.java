package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.GarageRepository;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ServiceEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {
    private final ServiceEntryRepository serviceEntryRepository;
    private final VehicleRepository vehicleRepository;
    private final GarageRepository garageRepository;

    public ServiceEntryServiceImpl(ServiceEntryRepository serviceEntryRepository, VehicleRepository vehicleRepository, GarageRepository garageRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.vehicleRepository = vehicleRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry e) {
        Vehicle v = e.getVehicle();
        Garage g = e.getGarage();
        if (v == null || v.getId() == null) {
            throw new IllegalArgumentException("Vehicle missing");
        }
        if (g == null || g.getId() == null) {
            throw new IllegalArgumentException("Garage missing");
        }

        Vehicle vehicle = vehicleRepository.findById(v.getId()).orElseThrow(() -> new IllegalArgumentException("vehicle not found"));
        Garage garage = garageRepository.findById(g.getId()).orElseThrow(() -> new IllegalArgumentException("garage not found"));

        if (vehicle.getActive() != null && !vehicle.getActive()) {
            throw new IllegalArgumentException("active vehicles");
        }
        if (garage.getActive() != null && !garage.getActive()) {
            throw new IllegalArgumentException("garage inactive");
        }

        if (e.getServiceDate() != null && e.getServiceDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("service date future");
        }

        serviceEntryRepository.findTopByVehicleOrderByOdometerReadingDesc(vehicle).ifPresent(last -> {
            if (e.getOdometerReading() != null && last.getOdometerReading() != null
                    && e.getOdometerReading() < last.getOdometerReading()) {
                throw new IllegalArgumentException("odometer must be >= last reading");
            }
        });

        return serviceEntryRepository.save(e);
    }

    @Override
    public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
        return serviceEntryRepository.findByVehicleId(vehicleId);
    }
}
