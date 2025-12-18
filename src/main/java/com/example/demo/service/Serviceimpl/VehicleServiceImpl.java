package com.example.demo.service.Serviceimpl;
public class VehicleServiceImpl implements VehicleService{
    @Autowired VehicleRepository vehiclee;
    @Override
    public  Vehicle createVehicle(Vehicle vehi){
        return vehiclee.save(vehi);
        
    }

}