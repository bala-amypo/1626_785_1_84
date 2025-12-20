package com.example.demo.service.Serviceimpl;
public class VehicleServiceImpl implements VehicleService{
    @Autowired VehicleRepository vehiclee;
    @Override
    public  Vehicle createVehicle(Vehicle vehi){
        return vehiclee.save(vehi);
        
    }

}






package com.example.demo.service.Impl;
import org.springframework.stereotype.Service;
import com.example.demo.service.Studentservice;
import  com.example.demo.entity.Studententity;
import  com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class Studentserviceimpl implements Studentservice{
      @Autowired StudentRepository student;
      //save()
      //findall()
      //findById()
      //deleteById()
      //existsById()
      @Override
 public Studententity postdata(Studententity stu){
    return student.save(stu);
 }
 @Override
    public List<Studententity>getAllData(){
      return student.findAll();
     }
@Override
     public String DeleteData( int id){
          student.deleteById(id);
          return "Deleted Sucessfully";
     }
@Override
public Studententity findData(int id){
    return student.findById(id).orElse(null);
}
@Override
public Studententity UpdateData(int id, Studententity entity){
      if(student.existsById(id)){
         entity.setId(id);
         return student.save(entity);
      }
      return null;
}
 }







