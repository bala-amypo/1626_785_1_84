// package com.example.demo.controller;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import com.example.demo.entity.Vehicle;
// import com.example.demo.service.VehicleService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import java.util.List;

// @RestController
// public class VehicleController {

//     @Autowired VehicleService vehii;

//     @PostMapping("/POST")
//     public Vehicle dopost(@RequestBody Vehicle ve) {
//         return vehii.createVehicle(ve);
//     }

//     @GetMapping("/GET/{id}")
//     public Vehicle getVehicle(@PathVariable Long id) {
//         return vehii.getVehicleById(id);
//     }

//     @GetMapping("/GET/vin/{vin}")
//     public Vehicle getvinVehicle(@PathVariable String vin) {
//         return vehii.getVehicleByVin(vin);
//     }

//     @GetMapping("/GET/owner/{ownerId}")
//     public List<Vehicle> getownerIdVehicle(@PathVariable Long ownerId) {
//         return vehii.getVehicleByOwner(ownerId);
//     }

//     @PutMapping("/PUT/{id}")
//     public void deactivateVehicle(@PathVariable Long id) {
//         vehii.deactivateVehicle(id);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicles")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping("/vehicles/owner/{ownerId}")
    public List<Vehicle> byOwner(@PathVariable Long ownerId) {
        return vehicleService.getVehiclesByOwner(ownerId);
    }

    @PostMapping("/vehicles/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
    }
}

