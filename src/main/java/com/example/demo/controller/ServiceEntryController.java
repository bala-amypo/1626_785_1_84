package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
public class ServiceEntryController {

    @Autowired
    private ServiceEntryService service;

    @PostMapping
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return service.createServiceEntry(entry);
    }

    @GetMapping("/{id}")
    public ServiceEntry getServiceEntryById(@PathVariable Long id) {
        return service.getServiceEntryById(id);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<ServiceEntry> getEntriesForVehicle(@PathVariable Long vehicleId) {
        return service.getEntriesForVehicle(vehicleId);
    }

    @GetMapping("/garage/{garageId}")
    public List<ServiceEntry> getEntriesByGarage(@PathVariable Long garageId) {
        return service.getEntriesByGarage(garageId);
    }
}
