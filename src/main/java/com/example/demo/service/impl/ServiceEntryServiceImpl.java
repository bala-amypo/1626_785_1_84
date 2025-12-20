package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.ServiceEntry;
import com.example.demo.repositiry.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;

@Service
public class ServiceEntryServiceImpl implements ServiceEntryService{
    private final ServiceEntryRepository s;

    public ServiceEntryServiceImpl(ServiceEntryRepository s) {
        this.s = s;
    }
    @Override
    public ServiceEntry createServiceEntry(ServiceEntry entry) {
        return s.save(entry);
    }
    @Override
    public ServiceEntry getServiceEntryById(Long id){
      return s.findById(id).orElse(null);
     }
     
}