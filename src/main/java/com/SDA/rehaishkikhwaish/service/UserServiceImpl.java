package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        //hashing the password here
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User user){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);
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
        return Optional.of(userRepository.findAll()).orElse(null);
    }

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
