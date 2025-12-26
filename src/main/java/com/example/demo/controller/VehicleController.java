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

// // package com.example.demo.controller;

// // import com.example.demo.model.Vehicle;
// // import com.example.demo.service.VehicleService;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // import jakarta.validation.Valid;
// // import java.util.List;

// // @RestController
// // @RequestMapping("/vehicles")
// // public class VehicleController {
// //     private final VehicleService vehicleService;

// //     public VehicleController(VehicleService vehicleService) {
// //         this.vehicleService = vehicleService;
// //     }

// //     @PostMapping
// //     public ResponseEntity<Vehicle> createVehicle(@Valid @RequestBody Vehicle v) {
// //         return ResponseEntity.ok(vehicleService.createVehicle(v));
// //     }

// //     @GetMapping("/{id}")
// //     public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
// //         return ResponseEntity.ok(vehicleService.getVehicleById(id));
// //     }

// //     @GetMapping("/byOwner/{ownerId}")
// //     public ResponseEntity<List<Vehicle>> getByOwner(@PathVariable Long ownerId) {
// //         return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
// //     }

// //     @PostMapping("/{id}/deactivate")
// //     public ResponseEntity<Void> deactivate(@PathVariable Long id) {
// //         vehicleService.deactivateVehicle(id);
// //         return ResponseEntity.ok().build();
// //     }
// // }


package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // 1) Create Vehicle
    // POST /api/vehicles
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle saved = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // 2) Get Vehicle by ID
    // GET /api/vehicles/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // 3) Get Vehicle by VIN
    // GET /api/vehicles/vin/{vin}
    @GetMapping("/vin/{vin}")
    public ResponseEntity<Vehicle> getVehicleByVin(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getVehicleByVin(vin));
    }

    // 4) List Vehicles by Owner
    // GET /api/vehicles/owner/{ownerId}
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
    }

    // 5) Deactivate Vehicle
    // PUT /api/vehicles/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateVehicle(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
        return ResponseEntity.noContent().build();
    }

    // (Optional) Delete Vehicle
    // DELETE /api/vehicles/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        // If you want strict "not found" behavior, call service.getVehicleById(id) first.
        // For now, you can add delete to service later if needed.
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
