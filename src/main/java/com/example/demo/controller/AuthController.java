
// package com.example.demo.controller;
// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// @RestController
// public class AuthController {

//     private final UserService userr;

//     public AuthController(UserService userr) {
//         this.userr = userr;
//     }

//     @PostMapping("/regg")
//     public String register(@RequestBody User user) {
//         return userr.createUser(user); 
//     }
//     @GetMapping("/GETTReg")
//     public List<User>getAll(){
//     return userr.getAllUser();
// }
// }
