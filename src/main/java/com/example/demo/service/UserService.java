package com.example.demo.service;
import java.util.List;
import com.example.demo.model.UserService;
public interface UserService{
     UserService createGarage(UserService reg);
     List<UserService>getAllUser();
}