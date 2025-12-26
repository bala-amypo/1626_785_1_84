package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
public class ServicePartController {

    private final ServicePartService ser;

    public ServicePartController(ServicePartService ser) {
        this.ser = ser;
    }

    @PostMapping
    public ServicePart createPart(@RequestBody ServicePart part) {
        return ser.createPart(part);
    }

    @GetMapping("/{id}")
    public ServicePart getPartById(@PathVariable Long id) {
        return ser.getPartById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePart> getPartsForEntry(@PathVariable Long entryId) {
        return ser.getPartsForEntry(entryId);
    }
}
