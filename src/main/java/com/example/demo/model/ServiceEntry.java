// // package com.example.demo.model;

// // import jakarta.persistence.*;
// // import lombok.AllArgsConstructor;
// // import lombok.Data;
// // import lombok.NoArgsConstructor;

// // import java.time.LocalDate;
// // import java.time.LocalDateTime;

// // @Entity
// // @Data
// // @AllArgsConstructor
// // @NoArgsConstructor
// // public class ServiceEntry {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @ManyToOne
// //     @JoinColumn(name = "vehicle_id")
// //     private Vehicle vehicle;

// //     @ManyToOne
// //     @JoinColumn(name = "garage_id")
// //     private Garage garage;

// //     private String serviceType;

// //     private LocalDate serviceDate;

// //     private Integer odometerReading;

// //     private String description;

// //     private LocalDateTime recordedAt;

// //     @PrePersist
// //     public void onCreate() {
// //         if (this.recordedAt == null) {
// //             this.recordedAt = LocalDateTime.now();
// //         }
// //     }
// // }

// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;

// import java.time.LocalDate;

// @Entity
// public class ServiceEntry {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne
//     @JoinColumn(name = "vehicle_id")
//     private Vehicle vehicle;

//     @ManyToOne
//     @JoinColumn(name = "garage_id")
//     private Garage garage;

//     private String serviceType;

//     private LocalDate serviceDate;

//     private Integer odometerReading;

//     public ServiceEntry() { }

//     @PrePersist
//     public void prePersist() {
//         // optional, keep empty if not needed
//     }

//     // getters/setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Vehicle getVehicle() { return vehicle; }
//     public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

//     public Garage getGarage() { return garage; }
//     public void setGarage(Garage garage) { this.garage = garage; }

//     public String getServiceType() { return serviceType; }
//     public void setServiceType(String serviceType) { this.serviceType = serviceType; }

//     public LocalDate getServiceDate() { return serviceDate; }
//     public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }

//     public Integer getOdometerReading() { return odometerReading; }
//     public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
// }
