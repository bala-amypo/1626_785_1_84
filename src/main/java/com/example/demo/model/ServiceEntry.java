package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
import java.util.Date;
public class ServiceEntry{
    @Id
    private Long id;
    //private Manytoone vehicle;
    //private manytoone garage;
    private String serviceType;
    private Date serviceDate;
    private Integer odometerReading;
    private String description;
    private Date recordedAt;

}