package com.example.demo.service.impl;

import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;
import org.springframework.stereotype.Service;

@Service
public class ServicePartServiceImpl implements ServicePartService {
    private final ServicePartRepository servicePartRepository;
    private final ServiceEntryRepository serviceEntryRepository;

    public ServicePartServiceImpl(ServicePartRepository servicePartRepository, ServiceEntryRepository serviceEntryRepository) {
        this.servicePartRepository = servicePartRepository;
        this.serviceEntryRepository = serviceEntryRepository;
    }

    @Override
    public ServicePart createPart(ServicePart p) {
        if (p.getServiceEntry() == null || p.getServiceEntry().getId() == null) {
            throw new IllegalArgumentException("ServiceEntry missing");
        }
        serviceEntryRepository.findById(p.getServiceEntry().getId()).orElseThrow(() -> new IllegalArgumentException("service entry not found"));
        if (p.getQuantity() == null || p.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        return servicePartRepository.save(p);
    }
}
