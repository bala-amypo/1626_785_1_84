package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Garage;
import com.example.demo.repositiry.GarageRepository;
import com.example.demo.service.GarageService;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository g;

    public GarageServiceImpl(GarageRepository g) {
        this.g = g;
    }

    @Override
    public Garage createGarage(Garage garage) {
        return g.save(garage);
    }
    @Override
public Garage UpdateGarage(Long id, Garage garage){
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
     @Override
public void deactivateGarage(Long id) {
    Garage garage = g.findById(id).orElse(null);
    if (garage != null) {
        garage.setIsactive(false);  
        g.save(garage);
    }
}



}