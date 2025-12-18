package com.example.demo.service;
import com.example.demo.entity.Vehicle;
import java.util.List;
public interface VehicleService{
    Vehicle postdata(Vehicle vehi);
    List<Vehicle>getAllData();
    String DeleteData(int id);
    Vehicle findData(int id);
    Vehicle UpdateData(int id,Vehicle entity);

}