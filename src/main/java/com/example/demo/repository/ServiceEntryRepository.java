package com.example.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ServiceEntry;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

    List<ServiceEntry> findByVehicle_Id(Long vehicleId);

    List<ServiceEntry> findByGarage_Id(Long garageId);
}
