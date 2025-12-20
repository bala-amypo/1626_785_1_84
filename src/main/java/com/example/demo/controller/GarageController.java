package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
@RestController
public class GarageController {
@Autowired GarageService garr;
@PostMapping("/POST")
public Garage Garagepost(@RequestBody Garage garage){
    return garr.createGarage(garage);

}
@PutMapping("/PUT/{id}")
public Garage putGarage(@PathVariable Long id, @RequestBody Garage garage){
    return garr.UpdateGarage(id,garage);
}
@GetMapping("/get/{id}")
public Garage getGarage(Long id){
    return garr.getGarageById(id);
}
@GetMapping("/GET")
public List<Garage>getGarages(){
    return garr.getAllGarage();
}


}




