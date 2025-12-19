package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@Builder
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
    private Long odometerReading;

    @NotNull
    @Positive
    private BigDecimal cost;

    @Lob
    @Size(max = 2000)
    private String notes;

    @CreationTimestamp
    private LocalDateTime submittedAt;

    @OneToMany(mappedBy = "serviceEntry")
    private List<ServicePart> parts;

    @OneToMany(mappedBy = "serviceEntry")
    private List<VerificationLog> verificationLogs;
}
