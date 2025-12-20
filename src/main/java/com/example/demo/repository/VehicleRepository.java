package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository <Vehicle,Long>{
      Vehicle findByVin(String vin);
}