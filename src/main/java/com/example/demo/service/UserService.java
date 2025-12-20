
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
    String createUser(User user);
    User getUserById(Long id);
    List<User> getAllUser();
}
