package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;

// @Service
// public class ServiceEntryServiceImpl implements ServiceEntryService {

//     private final ServiceEntryRepository s;

//     public ServiceEntryServiceImpl(ServiceEntryRepository s) {
//         this.s = s;
//     }

//     @Override
//     public ServiceEntry createServiceEntry(ServiceEntry entry) {
//         return s.save(entry);
//     }

//     @Override
//     public ServiceEntry getServiceEntryById(Long id) {
//         return s.findById(id).orElse(null);
//     }

//     @Override
//     public List<ServiceEntry> getEntriesForVehicle(Long vehicleId) {
//         return s.findAll();
//     }

//     @Override
//     public ServiceEntry getEntriesByGarage(Long garageId) {
//         return s.findById(garageId).orElse(null);
//     }
// }
@Service
public class ServiceEntryServiceImpl implements ServiceEntryService {

    private final ServiceEntryRepository serviceEntryRepository;
    private final GarageRepository garageRepository;
    private final VehicleRepository vehicleRepository;

    public ServiceEntryServiceImpl(
            ServiceEntryRepository serviceEntryRepository,
            GarageRepository garageRepository,
            VehicleRepository vehicleRepository) {
        this.serviceEntryRepository = serviceEntryRepository;
        this.garageRepository = garageRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {

        // ✅ Fetch managed entities
        Garage garage = garageRepository.findById(
                entry.getGarage().getId()
        ).orElseThrow(() -> new RuntimeException("Garage not found"));

        Vehicle vehicle = vehicleRepository.findById(
                entry.getVehicle().getId()
        ).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        // ✅ Attach managed entities
        entry.setGarage(garage);
        entry.setVehicle(vehicle);

        return serviceEntryRepository.save(entry);
    }
}
