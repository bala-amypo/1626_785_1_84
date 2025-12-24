package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles", uniqueConstraints = { @UniqueConstraint(columnNames = { "vin" }) })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    private String make;
    private String model;

    @Column(nullable = false)
    private Long ownerId;

    @Column(nullable = false)
    private Boolean active;


    @PrePersist
    public void on() {
        if (this.verifiedAt == null) {
            this.verifiedAt = LocalDateTime.now();
        }
    }
}
