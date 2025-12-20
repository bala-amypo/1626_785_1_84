package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Garage;
import com.example.demo.service.ServiceEntryService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ServiceEntryController {

    private final ServiceEntryService serr;

    public ServiceEntryController(ServiceEntryService serr) {
        this.serr = serr;
    }

    @PostMapping("/POSTTT")
    public ServiceEntry createServiceEntry(@RequestBody ServiceEntry entry) {
        return serr.createServiceEntry(entry);
    }

    @GetMapping("/GETTT/vehicle/{vehicleId}")
    public List<ServiceEntry> getvehicleId(@PathVariable Long vehicleId) {
        return serr.getEntriesForVehicle(vehicleId);
    }

    @GetMapping("/gettt/{id}")
    public ServiceEntry getServiceEntry(@PathVariable Long id) {
        return serr.getServiceEntryById(id);
    }

    @GetMapping("/get/garage/{garageId}")
    public List<ServiceEntry> getServiceGarage(@PathVariable Long garageId) {
        return serr.getEntriesByGarage(garageId);
    }
}
