package com.raginicodes.fullstack.controller;

import com.raginicodes.fullstack.exception.UserNotFoundException;
import com.raginicodes.fullstack.model.user;
import com.raginicodes.fullstack.repository.userrepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class usercontroller {
    @Autowired
    private userrepository UserRepository;
    @PostMapping("/user")
    user newuser(@RequestBody user newuser){
        return UserRepository.save(newuser);


    }
    @GetMapping("/users")
    List<user> getAllUsers(){
        return UserRepository.findAll();
    }

    @GetMapping("/user/{id}")
    user getUserById(@PathVariable Long id){
        return UserRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    user updateUser(@RequestBody user newUser,@PathVariable Long id ){
        return UserRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return UserRepository.save(user);

                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!UserRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        UserRepository.deleteById(id);
        return "User with the entered User ID "+id+" has been deleted successfully";
    }


}
