// // package com.example.demo.model;

// // import jakarta.persistence.Entity;
// // import jakarta.persistence.GeneratedValue;
// // import jakarta.persistence.GenerationType;
// // import jakarta.persistence.Id;
// // import jakarta.persistence.JoinColumn;
// // import jakarta.persistence.ManyToOne;
// // import java.sql.Timestamp;
// // import lombok.AllArgsConstructor;
// // import lombok.Data;
// // import lombok.NoArgsConstructor;

// // @Entity
// // @Data
// // @AllArgsConstructor
// // @NoArgsConstructor
// // public class VerificationLog {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @ManyToOne
// //     @JoinColumn(name = "service_entry_id")
// //     private ServiceEntry serviceEntry;

// //     private Timestamp verifiedAt;

// //     private Boolean verifiedBySystem = true;

// //     private String notes;
// // }





// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.util.Objects;

// @Entity
// @Table(
//         name = "vehicles",
//         uniqueConstraints = @UniqueConstraint(name = "uk_vehicle_vin", columnNames = "vin")
// )
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, length = 64)
//     private String vin;

//     @Column(nullable = false, length = 60)
//     private String make;

//     @Column(nullable = false, length = 60)
//     private String model;

//     @Column(name = "owner_id", nullable = false)
//     private Long ownerId;

//     @Column(nullable = false)
//     private Boolean active = true;

//     // getters/setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getVin() { return vin; }
//     public void setVin(String vin) { this.vin = vin; }

//     public String getMake() { return make; }
//     public void setMake(String make) { this.make = make; }

//     public String getModel() { return model; }
//     public void setModel(String model) { this.model = model; }

//     public Long getOwnerId() { return ownerId; }
//     public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

//     public Boolean getActive() { return active; }
//     public void setActive(Boolean active) { this.active = active; }

//     // JPA-safe equals/hashCode (id-based)
//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (!(o instanceof Vehicle)) return false;
//         Vehicle vehicle = (Vehicle) o;
//         return id != null && Objects.equals(id, vehicle.id);
//     }

//     @Override
//     public int hashCode() {
//         return 31;
//     }
// }
