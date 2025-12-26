// // package com.example.demo.repository;

// // import com.example.demo.model.ServiceEntry;
// // import com.example.demo.model.Vehicle;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.stereotype.Repository;

// // import java.util.List;

// // @Repository
// // public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

// //     ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

// //     List<ServiceEntry> findByVehicleId(Long vehicleId);

// //     List<ServiceEntry> findByGarageId(Long garageId);
// // }

// package com.example.demo.repository;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.model.Vehicle;
// import java.time.LocalDate;
// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {

//     ServiceEntry findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);

//     List<ServiceEntry> findByVehicleId(Long vehicleId);

//     List<ServiceEntry> findByGarageId(Long garageId);

//     // ✅ required by test
//     List<ServiceEntry> findByGarageAndMinOdometer(long garageId, int minOdometer);

//     // ✅ required by test
//     List<ServiceEntry> findByVehicleAndDateRange(long vehicleId, LocalDate startDate, LocalDate endDate);
// }
