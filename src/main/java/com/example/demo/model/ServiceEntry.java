// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// import java.time.LocalDate;
// import java.time.LocalDateTime;

// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
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

//     private String description;

//     private LocalDateTime recordedAt;

//     @PrePersist
//     public void onCreate() {
//         if (this.recordedAt == null) {
//             this.recordedAt = LocalDateTime.now();
//         }
//     }
// }
