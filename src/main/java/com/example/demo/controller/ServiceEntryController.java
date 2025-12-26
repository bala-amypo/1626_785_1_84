package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service-entries")
public class ServiceEntryController {
    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    @PostMapping
    public ResponseEntity<ServiceEntry> create(@Valid @RequestBody ServiceEntry e) {
        return ResponseEntity.ok(serviceEntryService.createServiceEntry(e));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceEntry>> entriesForVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(serviceEntryService.getEntriesForVehicle(vehicleId));
    }
}
