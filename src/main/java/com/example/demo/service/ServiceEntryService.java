package com.example.demo.service;
import com.example.demo.model.ServiceEntry;
public interface ServiceEntryService{
    ServiceEntry createServiceEntry(ServiceEntry entry);
    ServiceEntry getServiceEntryById(Long id);
    ServiceEntry getEntriesForVehicle(Long vehicleId);
    ServiceEntry getEntriesByGarage(Long garageId);
}