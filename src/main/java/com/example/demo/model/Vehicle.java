// package com.example.demo.entity;
// import java.time.LocalDateTime;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Column;
// import jakarta.persistence.PrePersist;
// import jakarta.validation.constraints.NotNull;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// @Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Vehicle {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Integer id;
//     @NotNull
//     @Column(name = "vin", unique = true)
//     private String vin;
//     private String make;
//     private String model;
//     private int year;
//     @NotNull
//     private long ownerId;
//     private Boolean isactive=true;
//     private LocalDateTime created;
//     @PrePersist
//     public void Oncreate() {
//         LocalDateTime now = LocalDateTime.now();
//         if (this.created == null) {
//             this.created = now;
//         }
//     }
    
// }

package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "VIN cannot be empty")
    @Size(min = 17, max = 17, message = "VIN must be exactly 17 characters")
    @Column(unique = true, nullable = false)
    private String vin;

    @NotBlank(message = "Brand cannot be empty")
    private String brand;

    @NotBlank(message = "Model cannot be empty")
    private String model;

    @Pattern(regexp = "PETROL|DIESEL|ELECTRIC", message = "Fuel must be PETROL, DIESEL or ELECTRIC")
    private String fuelType;
}
