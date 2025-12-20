package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.example.demo.entity.Vehicle;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @OneToOne
@JoinColumn(name = "vehicle_id", nullable = false)
private Vehicle vehicle;

@OneToOne
@JoinColumn(name = "garage_id", nullable = false)
private Garage garage;

@NotBlank
private String serviceType;

@NotNull
private LocalDate serviceDate;

@NotNull
@Positive
private int odometerReading;
private String description;
private LocalDateTime recordedAt;

    @PrePersist
    public void Onrecord() {
        if (this.recordedAt == null) {
            this.recordedAt = LocalDateTime.now();
        }
    }
}
