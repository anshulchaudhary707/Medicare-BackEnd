package com.example.medicare.service;

import com.example.medicare.dto.UserDto;

public interface UserService{
    //save user
    UserDto saveUser(UserDto userDto);

    //update user
    UserDto updateUser(UserDto userDto);
}
