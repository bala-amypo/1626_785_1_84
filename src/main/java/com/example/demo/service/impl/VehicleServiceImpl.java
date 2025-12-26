

// package com.example.demo.service.impl;

// import com.example.demo.model.Vehicle;
// import com.example.demo.repository.VehicleRepository;
// import com.example.demo.service.VehicleService;
// import jakarta.persistence.EntityNotFoundException;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class VehicleServiceImpl implements VehicleService {

//     private final VehicleRepository vehicleRepository;

//     public VehicleServiceImpl(VehicleRepository vehicleRepository) {
//         this.vehicleRepository = vehicleRepository;
//     }

//     @Override
//     public Vehicle createVehicle(Vehicle v) {
//         if (v.getVin() != null && vehicleRepository.findByVin(v.getVin()).isPresent()) {
//             throw new IllegalArgumentException("VIN already exists");
//         }
//         return vehicleRepository.save(v);
//     }

//     @Override
//     public Vehicle getVehicleById(Long id) {
//         return vehicleRepository.findById(id)
//                 .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
//     }

//     @Override
//     public List<Vehicle> getVehiclesByOwner(Long ownerId) {
//         return vehicleRepository.findByOwnerId(ownerId);
//     }

//     @Override
//     public void deactivateVehicle(Long id) {
//         Vehicle v = getVehicleById(id);
//         v.setActive(false);
//         vehicleRepository.save(v);
//     }

//     @Override
//     public Vehicle getVehicleByVin(String vin) {
//         Optional<Vehicle> opt = vehicleRepository.findByVin(vin);
//         return opt.orElse(null);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository v;

    public VehicleServiceImpl(VehicleRepository v) {
        this.v = v;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

        Vehicle existing = v.findByVin(vehicle.getVin());
        if (existing != null) {
            throw new IllegalArgumentException("VIN already exists");
        }

        if (vehicle.getActive() == null) {   // ✅ changed
            vehicle.setActive(true);         // ✅ changed
        }

        return v.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return v.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public Vehicle getVehicleByVin(String vin) {
        Vehicle vehicle = v.findByVin(vin);
        if (vehicle == null) {
            throw new EntityNotFoundException("Vehicle not found");
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleByOwner(Long ownerId) {
        return v.findByOwnerId(ownerId);
    }

    @Override
    public void deactivateVehicle(Long id) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setActive(false);           // ✅ changed
        v.save(vehicle);
    }
}
