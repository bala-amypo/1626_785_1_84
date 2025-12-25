// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.entity.ServiceEntry;
// import com.example.demo.entity.Vehicle;

// import java.util.Optional;
// import java.util.List;

// public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

//     Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

//     List<ServiceEntry> findByVehicleId(Long vehicleId);

//     List<ServiceEntry> findByGarageId(Long garageId);
// }
