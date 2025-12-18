package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
import java.util.Date;
public class Garage{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
     private String garageName;
     private String address;
     private String contactNumber;
     private boolean active;
     public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getId(){
        return garageName;
    }
    public void setId(String vin){
        this.vin=vin;
    }
    public String getId(){
        return make;
    }
    public void setId(String make){
        this.make=make;
    }
    public String  getId(){
        return model;
    }
    public void setId(String model){
        this.model=model;
    }
    public int getId(){
        return year;
    }
    public void setId(int year){
        this.year=year;
    }
    public long getId(){
        return ownerld;
    }
    public void setId(long ownerld){
        this.ownerld=ownerld;
    }
    public boolean getId(){
        return active;
    }
    public void setId(boolean active){
        this.active=active;
    }
    public Date getId(){
        return createdAt;
    }
    public void setId(Date id){
        this.createdAt=createdAt;
    }


    
}