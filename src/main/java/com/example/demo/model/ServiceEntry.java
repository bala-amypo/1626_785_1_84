package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "service_entries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    private String serviceType;

    private LocalDate serviceDate;

    private Integer odometerReading;

    @Column(length = 2000)
    private String description;

    @CreationTimestamp
    private LocalDateTime recordedAt;
}
