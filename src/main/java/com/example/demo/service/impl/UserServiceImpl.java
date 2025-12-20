package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserService;
import com.example.demo.repositiry.UserServiceRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    
    private final UserServiceRepository u;

    public GarageServiceImpl(UserServiceRepository u) {
        this.u = u;
    }

    @Override
    public UserService createGarage(UserService reg) {
        return g.save(garage);
    }
}