package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;

@RestController
public class ServicePartController {

    private final ServicePartService server;

    public ServicePartController(ServicePartService server) {
        this.server = server;
    }

    @PostMapping("/part")
    public ServicePart createPart(@RequestBody ServicePart part) {
        return server.createServicePart(part);
    }

    @GetMapping("/part/entry/{entryId}")
    public List<ServicePart> getPart(@PathVariable Long entryId) {
        return server.getPartsForEntry(entryId);
    }

    @GetMapping("/part/{id}")
    public ServicePart getPartById(@PathVariable Long id) {
        return server.getPartById(id);
    }
}
