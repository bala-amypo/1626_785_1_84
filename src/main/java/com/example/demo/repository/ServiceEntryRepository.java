package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;

import java.util.List;

@Repository
public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

    List<ServiceEntry> findByVehicleId(Long vehicleId);
}
