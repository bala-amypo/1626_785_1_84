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

import java.util.List;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
        return service.createVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return service.getVehicleById(id);
    }

    @GetMapping("/vin/{vin}")
    public Vehicle getVehicleByVin(@PathVariable String vin) {
        return service.getVehicleByVin(vin);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }
}
