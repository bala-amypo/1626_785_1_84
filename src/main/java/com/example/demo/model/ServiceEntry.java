
package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.example.demo.entity.Vehicle;  
import com.example.demo.model.Garage;   

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    @NotBlank
    @NotNull
    private String serviceType;

    @NotNull
    private LocalDate serviceDate;

    @NotNull
    @Positive
    private int odometerReading;

    @NotNull
    private String description;

    @NotNull
    private LocalDateTime recordedAt;

    @PrePersist
    public void Onrecord() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }
}
