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
      public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    // public String getId(){
    //     return vehicle;
    // }
    // public void setId(String vehicle){
    //     this.vehicle=vehicle;
    // }
    // public String getId(){
    //     return garage;
    // }
    // public void setId(String garage){
    //     this.garage=garage;
    // }
    public String  getId(){
        return serviceType;
    }
    public void setId(String serviceType){
        this.serviceType=serviceType;
    }
    public Date getId(){
        return serviceDate;
    }
    public void setId(Date serviceDate){
        this.serviceDate=serviceDate;
    }
    public int getId(){
        return odometerReading;
    }
    public void setId(int odometerReading{
        this.odometerReading=odometerReading;
    }
    public String getId(){
        return description;
    }
    public void setId(String description){
        this.active=active;
    }
    public Date getId(){
        return createdAt;
    }
    public void setId(Date id){
        this.createdAt=createdAt;
    }

}