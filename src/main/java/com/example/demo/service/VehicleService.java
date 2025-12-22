// package com.example.demo.service;
// import com.example.demo.entity.Vehicle;
// import java.util.List;

// public interface VehicleService {

//     Vehicle createVehicle(Vehicle vehicle);

//     Vehicle getVehicleById(Long id);

//     Vehicle getVehicleByVin(String vin);

//     List<Vehicle>getVehicleByOwner(Long ownerId);

//     void deactivateVehicle(Long id);
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    Vehicle getVehicleByVin(String vin);

    List<Vehicle> getAllVehicles();
}
