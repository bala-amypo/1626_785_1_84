package com.example.demo.service.impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.VehicleService;
import  com.example.demo.entity.Vehicle;
import  com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

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
      return v.findById(id).orElse(null);
     }
    @Override
    public Vehicle getVehicleByVin(String vin) {
      return v.findById(vin);
     }
    @Override
    public  List <Vehicle> getVehicleByOwner(Long ownerId){
        return v.findAll();
    }
    @Override
    public void deactivateVehicle(Long id){
         Vehicle vehicle=v.findById(id).orElse(null);
         if(vehicle!=null){
            vehicle.setIsactive(false);
            v.save(vehicle);
         }
    }

}





