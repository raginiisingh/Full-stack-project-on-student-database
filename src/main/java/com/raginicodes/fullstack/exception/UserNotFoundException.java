package com.raginicodes.fullstack.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("User not found with the entered User ID "+id);
    }
}
