package com.example.demo.service.impl;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.ServicePart;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.repository.ServicePartRepository;
import com.example.demo.service.ServicePartService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePartServiceImpl implements ServicePartService {

    private final ServicePartRepository repo;
    private final ServiceEntryRepository entryRepo;

    public ServicePartServiceImpl(ServicePartRepository repo, ServiceEntryRepository entryRepo) {
        this.repo = repo;
        this.entryRepo = entryRepo;
    }

    @Override
    public ServicePart createPart(ServicePart part) {

        if (part == null || part.getServiceEntry() == null || part.getServiceEntry().getId() == null) {
            throw new IllegalArgumentException("ServiceEntry not found");
        }

        if (part.getQuantity() == null || part.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }

        ServiceEntry entry = entryRepo.findById(part.getServiceEntry().getId())
                .orElseThrow(() -> new EntityNotFoundException("ServiceEntry not found"));

        part.setServiceEntry(entry);

        return repo.save(part);
    }

    @Override
    public ServicePart getPartById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ServicePart not found"));
    }

    @Override
    public List<ServicePart> getPartsForEntry(Long entryId) {
        return repo.findByServiceEntryId(entryId);
    }
}
