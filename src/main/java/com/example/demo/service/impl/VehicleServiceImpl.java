

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
