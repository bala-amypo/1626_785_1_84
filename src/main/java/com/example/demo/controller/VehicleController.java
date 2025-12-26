// package com.example.demo.controller;

// import com.example.demo.model.Vehicle;
// import com.example.demo.service.VehicleService;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class VehicleController {

//     @Autowired
//     private VehicleService ser;

//     @PostMapping("/vehicles")
//     public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
//         return ser.createVehicle(vehicle);
//     }

//     @GetMapping("/vehicles/{id}")
//     public Vehicle getVehicleById(@PathVariable Long id) {
//         return ser.getVehicleById(id);
//     }

//     @GetMapping("/vehicles/vin/{vin}")
//     public Vehicle getVehicleByVin(@PathVariable String vin) {
//         return ser.getVehicleByVin(vin);
//     }

//     @GetMapping("/vehicles/owner/{ownerId}")
//     public List<Vehicle> getByOwner(@PathVariable Long ownerId) {
//         return ser.getVehicleByOwner(ownerId);
//     }

//     @PutMapping("/vehicles/{id}/deactivate")
//     public String deactivate(@PathVariable Long id) {
//         ser.deactivateVehicle(id);
//         return "Deactivated Successfully";
//     }
// }
package com.example.demo.service;

import com.example.demo.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle createVehicle(Vehicle v);
    Vehicle getVehicleById(Long id);
    List<Vehicle> getVehiclesByOwner(Long ownerId);
    void deactivateVehicle(Long id);
    Vehicle getVehicleByVin(String vin);
}

