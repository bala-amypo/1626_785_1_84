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
    public   ServicePart createServicePart(ServicePart part) {
        return g.save(garage);
    }
    @Override
public {
      if(g.existsById(id)){
         garage.setId(id);
         return g.save(garage);
      }
      return null;
}
 @Override
    public Garage getGarageById(Long id){
      return g.findById(id).orElse(null);
     }
     @Override
    public List<Garage>getAllGarage(){
      return g.findAll();
     }
}