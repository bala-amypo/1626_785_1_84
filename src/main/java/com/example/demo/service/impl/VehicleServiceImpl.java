package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.Studentservice;
import  com.example.demo.entity.Studententity;
import  com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleServiceImpl implements VehicleService{
    private final VehicleRepository v;
    public VehicleServiceImpl(VehicleRepository v){
        this.v=v;
    }
    @Override
    public  Vehicle createVehicle(Vehicle vehicle){
        return v.save(vehicle);
        
    }
    @Override
    public Vehicle getVehicleById(Long id){
      return v.findAll();
     }
    @Override
    public Vehicle getVehicleByVin(String vin) {
      return v.findAll();
     }
    @Override
    public Vehicle getVehicleByOwner(Long ownerId){
        return v.findAll();
    }
    @Override
    public   void deactivateVehicle(Long id){
         Vehicle vehicle=v.findById(id).orElse(null);
         if(vehicle!=null){
            vehicle.setIsactive(false);
            v.save()
         }
    }

}





