package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public List<ServiceEntry> getvehicleId(@PathVariable Long ownerId) {
        return serr.getEntriesForVehicle(Long vehicleId);
    }
    

}
