// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import jakarta.persistence.EntityNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepo;

//     public UserServiceImpl(UserRepository userRepo) {
//         this.userRepo = userRepo;
//     }

//     @Override
//     public User register(User user) {

//         if (user == null) {
//             throw new IllegalArgumentException("User cannot be null");
//         }
//         if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
//             throw new IllegalArgumentException("Email is required");
//         }
//         if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
//             throw new IllegalArgumentException("Password is required");
//         }
//         if (user.getRole() == null || user.getRole().trim().isEmpty()) {
//             throw new IllegalArgumentException("Role is required");
//         }

//         if (userRepo.existsByEmail(user.getEmail())) {
//             throw new IllegalArgumentException("Email already exists");
//         }

//         return userRepo.save(user);
//     }

//     @Override
//     public User login(String email, String password) {

//         if (email == null || email.trim().isEmpty()) {
//             throw new IllegalArgumentException("Email is required");
//         }
//         if (password == null || password.trim().isEmpty()) {
//             throw new IllegalArgumentException("Password is required");
//         }

//         User user = userRepo.findByEmail(email)
//                 .orElseThrow(() -> new EntityNotFoundException("User not found"));

//         if (!password.equals(user.getPassword())) {
//             throw new IllegalArgumentException("Invalid credentials");
//         }

//         return user;
//     }
// }
