// package com.example.demo.service;
// import java.util.List;
// import com.example.demo.model.User;
// public interface UserService{
//      UserService createUserService(UserService reg);
//      List<UserService>getAllUser();
// }
package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUser();
}
