package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Garage {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String garageName;
private String address;
private String contactNumber;
private Boolean active = true;
}