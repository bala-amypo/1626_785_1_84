package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;


@Entity

public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String vin;
private String make;
private String model;
private Integer year;
private Long ownerId;
private Boolean active = true;
private Instant createdAt = Instant.now();
}