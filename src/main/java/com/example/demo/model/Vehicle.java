package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
import java.util.Date;
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
    public Long getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getId(){
        return vin;
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
    public Vehicle(private Long id,
    @NotNull private String vin,
    private String make,
    private String model,
    private int year,
    @NotNull private long ownerld,
    private boolean active,
    private Date createdAt){
         this.id=id;
         this.vin=vin;
         this.make=make;
         this.model=model;
         this.year=year;
         this.ownerld=ownerld;
         this.active=active;
         this.createdAt=createdAt;
          


        
    }
    public Vehicle(){
        
    }




}