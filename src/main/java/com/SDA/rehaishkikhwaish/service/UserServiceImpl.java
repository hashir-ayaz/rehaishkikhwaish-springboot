package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import com.SDA.rehaishkikhwaish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }


}
