package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class VehicleController{
    @Autowired VehicleService vehii;
@PostMapping("/POST")
public Vehicle dopost(@RequestBody Vehicle ve){
    return vehii.createVehicle(ve);

}
@GetMapping("/GET/{id}")
 public Vehicle getVehicle(Long id){
    return vehii.getVehicleById(id);
}
@GetMapping("/GET/vin/{vin}")
 public Vehicle getvinVehicle(String vin){
    return vehii.getVehicleByVin(vin);
}
@GetMapping("/GET/owner/{ownerId}")
 public Vehicle getownerIdVehicle(Long ownerId){
    return vehii.getVehicleByOwner(ownerId);
}
@PutMapping("PUT/{id}")
public Studententity putVehicle(@PathVariable Long id){
    return vehii.deactivateVehicle(id);
}
}






