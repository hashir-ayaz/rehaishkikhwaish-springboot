package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;
    // Retrieve all users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findUserByEmail(email);
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found with email: " + email, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
    // Retrieve a single user by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userService.findUserById(id));
        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found with email: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        User delUser= userService.findUserById(id);
        if(delUser==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(id);
        return new ResponseEntity<>(delUser,HttpStatus.NO_CONTENT);
    }

    //update user with new details
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        // Optional: Check if the user exists
        Optional<User> existingUser = Optional.ofNullable(userService.findUserById(id));
        if(!existingUser.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // Assuming you have a method to update the user in your service
        user.setUserId(id); // Make sure the user has the correct ID
        User updatedUser = userService.registerUser(user); // This method might need to handle update logic specifically
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<Void> deleteByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.findUserByEmail(email);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(userOptional.get().getUserId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }




}


