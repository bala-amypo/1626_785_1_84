package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "vin", unique = true)
    private String vin;
    private String make;
    private String model;
    private int year;
    @NotNull
    private long ownerId;
    private Boolean isactive=true;
    private LocalDateTime created;
    @PrePersist
    public void Oncreate() {
        LocalDateTime now = LocalDateTime.now();
        if (this.created == null) {
            this.created = now;
        }
    }
    
}

