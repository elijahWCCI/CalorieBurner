package com.wcci.calorieburner.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wcci.calorieburner.Models.UserModel;
import com.wcci.calorieburner.Repositories.UserRepository;
import com.wcci.calorieburner.Services.UserService;

import java.util.List;
import java.util.Optional;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    } 

    // Create a new user
   /*  @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    } */

    // Get a list of all users
   /*  @GetMapping
    public List<UserModel> getAllUsers() {
        return Streamable.of(userService.getAll()).toList();
    } */

    // Get a user by ID
    /* @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long id) {
        Optional<UserModel> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    } */

    // Update a user by ID
   /*  @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel updatedUser) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedUser.setId(id);
        userService.save(updatedUser);
        return ResponseEntity.ok(updatedUser);
    } */

    // Delete a user by ID
   /*  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (!userService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }*/
}