package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
import java.util.Date;
public class User{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    
}