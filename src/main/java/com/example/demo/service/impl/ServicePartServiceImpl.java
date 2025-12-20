package com.example.demo.service.impl;
package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ServiceEntry;
import com.example.demo.repository.ServiceEntryRepository;
import com.example.demo.service.ServiceEntryService;

@Service
public class ServicePartServiceImpl implements ServicePartService{
       private final ServicePartRepository sp;

    public ServicePartServiceImpl(ServicePartRepository sp) {
        this.sp = sp;
    }

    @Override
    public ServicePart createServicePart(ServicePart part) {
        return sp.save(part);
    }

 @Override
    public ServicePart getPartById(Long id)  {
      return sp.findById(id).orElse(null);
     }
     @Override
    public List<ServicePart> getPartsForEntry(Long entryId){
      return sp.findAll();
     }
}