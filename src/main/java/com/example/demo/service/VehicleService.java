// package com.example.demo.service;

// import com.example.demo.model.Vehicle;
// import java.util.List;

// public interface VehicleService {

//     Vehicle createVehicle(Vehicle vehicle);

//     Vehicle getVehicleById(Long id);

//     Vehicle getVehicleByVin(String vin);

//     List<Vehicle> getVehicleByOwner(Long ownerId);

//     void deactivateVehicle(Long id);
// }
// package com.example.demo.service;

// import com.example.demo.model.Vehicle;

// import java.util.List;

// public interface VehicleService {
//     Vehicle createVehicle(Vehicle v);
//     Vehicle getVehicleById(Long id);
//     List<Vehicle> getVehiclesByOwner(Long ownerId);
//     void deactivateVehicle(Long id);
//     Vehicle getVehicleByVin(String vin);
// }

// package com.example.demo.service;

// import com.example.demo.model.Vehicle;
// import java.util.List;

// public interface VehicleService {

//     Vehicle createVehicle(Vehicle vehicle);

//     Vehicle getVehicleById(Long id);

//     Vehicle getVehicleByVin(String vin);

//     List<Vehicle> getVehiclesByOwner(Long ownerId);

//     void deactivateVehicle(Long id);
// }

package com.example.demo.service;

import com.example.demo.model.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    Vehicle getVehicleByVin(String vin);

    List<Vehicle> getVehicleByOwner(Long ownerId);

    
    default List<Vehicle> getVehicleByOwner(Long ownerId, boolean dummy) {
        return getVehicleByOwner(ownerId);
    }
    List<Vehicle> getVehicleByOwner(Long ownerId);

}
