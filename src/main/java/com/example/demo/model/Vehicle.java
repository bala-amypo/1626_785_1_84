package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
@Entity
public class Vehicle{
    @Id
    @Generated
    private Long id;
    @NotNull
    private String vin;
    private String make;
    private String model;
    private int year;
    @NotNull
    private long ownerld;
    private boolean active;
    private Date createdAt;
    public Long getI




}