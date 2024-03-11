package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.User;
import java.util.List;
public interface UserService {
    User saveUser(User user);
    User findUserById(Integer id);
    void deleteUser(Integer userId);
    List<User> findAllUsers();

//    User createUser(User user);
}
