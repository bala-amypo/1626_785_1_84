
// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository u;

//     public UserServiceImpl(UserRepository u) {
//         this.u = u;
//     }

//     @Override
//     public String createUser(User user) {
//         u.save(user);
//         return "Register Sucessfully";
//     }

//     @Override
//     public List<User> getAllUser() {
//         return u.findAll();
//     }
// }
