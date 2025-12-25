
package com.example.demo.repository;
import com.example.demo.model.Vehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


    Vehicle findByVin(String vin);

    List<Vehicle> findByOwnerId(Long ownerId);
}
