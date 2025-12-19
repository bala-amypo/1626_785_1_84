package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
        LocalDateTime now = LocalDateTime.now();
        if (this.recordedAt == null) {
            this.recordedAt = now;
        }
    }
}
