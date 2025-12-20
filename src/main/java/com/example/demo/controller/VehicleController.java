package com.example.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class VehicleController{
    @Autowired VehicleService ser;
@PostMapping("/post")
public Studententity dopost(@RequestBody Studententity stu){
    return ser.postdata(stu);

}
@GetMapping("/get")
public List<Studententity>getvalue(){
    return ser.getAllData();
}

}






