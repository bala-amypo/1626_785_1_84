package com.example.demo.model;
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




}