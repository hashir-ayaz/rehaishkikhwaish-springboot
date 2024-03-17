package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id){
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    @Override
    public List<User> findAllUsers(){
        return Optional.ofNullable(userRepository.findAll()).orElse(null);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
