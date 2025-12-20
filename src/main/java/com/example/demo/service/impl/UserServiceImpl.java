package com.example.demo.service.impl;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repositiry.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
    
    private final UserRepository u;

    public UserServiceImpl(UserRepository u) {
        this.u = u;
    }

    @Override
    public String createUserService(User reg) {
        u.save(reg);
        return "Registed Sucessfully";
    }


}