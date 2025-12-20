package com.example.demo.service;
import java.util.List;
import com.example.demo.model.ServicePartService;
public interface ServicePartService{
     ServicePart createServicePart(ServicePart part);
    List<ServicePart> getPartsForEntry(Long entryId);
        ServicePart getLogById(Long id);
}