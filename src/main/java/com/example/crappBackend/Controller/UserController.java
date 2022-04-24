package com.example.crappBackend.Controller;

import com.example.crappBackend.model.User;
import com.example.crappBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        //Posible exepcion
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public  void deleteUserById(@PathVariable Long id){
        userRepository.deleteById(id);
    }
}
