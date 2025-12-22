// package com.example.demo.service.impl;
// import org.springframework.stereotype.Service;
// import com.example.demo.service.VehicleService;
// import  com.example.demo.entity.Vehicle;
// import  com.example.demo.repository.VehicleRepository;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// @Service
// public class VehicleServiceImpl implements VehicleService {

//     private final VehicleRepository v;

//     public VehicleServiceImpl(VehicleRepository v) {
//         this.v = v;
//     }

//     @Override
//     public Vehicle createVehicle(Vehicle vehicle) {
//         return v.save(vehicle);
//     }

//     @Override
//     public Vehicle getVehicleById(Long id) {
//         return v.findById(id).orElse(null);
//     }


//     @Override
//     public Vehicle getVehicleByVin(String vin) {
//         return v.findByVin(vin);   
//     }

//     @Override
//     public List<Vehicle> getVehicleByOwner(Long ownerId) {
//         return v.findAll();
//     }

  
//     @Override
// public void deactivateVehicle(Long id) {
//     Vehicle vehicle = v.findById(id).orElse(null);
//     if (vehicle != null) {
//         vehicle.setIsactive(false);  
//         v.save(vehicle);
//     }
// }

// }

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.VehicleNotFoundException;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with ID: " + id));
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        Vehicle vehicle = repo.findByVin(vin);
        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle not found with VIN: " + vin);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }
}
