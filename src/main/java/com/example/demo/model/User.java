package com.example.demo.model;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Entity;
import java.util.Date;
public class User{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
     private String email;
     private String password;
     private String role;
     public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getId(){
        return  email;
    }
    public void setId(String email){
        this.email=email;
    }
    public String getId(){
        return  password;
    }
    public void setId(String password){
        this.password=password;
    }
    public String getId(){
        return  role;
    }
    public void setId(String role){
        this.role=role;
    }
    public User(Long id
     String email
     private String password;
     private String role;){

    }


    
}