package com.example.demo.service.Serviceimpl;
import org.springframework.stereotype.Service;
import com.example.demo.service.Studentservice;
import  com.example.demo.entity.Studententity;
import  com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VehicleServiceImpl implements VehicleService{
    @Autowired VehicleRepository v;
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
    public 
    Vehicle getVehicleByOwner(Long ownerId){
        return v.findAll();
    }
    

}





