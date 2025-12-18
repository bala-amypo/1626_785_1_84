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
    public void setId(String garageName){
        this.garageName=garageName;
    }
    public String getId(){
        return address;
    }
    public void setId(String address){
        this.address=address;
    }
    public String  getId(){
        return contactNumber;
    }
    public void setId(String contactNumber){
        this.contactNumber=contactNumber;
    }
    public boolean getId(){
        return active;
    }
    public void setId(boolean active){
        this.active=active;
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
    public 


    
}