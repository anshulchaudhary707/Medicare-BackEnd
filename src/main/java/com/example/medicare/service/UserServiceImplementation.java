package com.example.medicare.service;

import com.example.medicare.dto.UserDto;
import com.example.medicare.module.Role;
import com.example.medicare.module.User;
import com.example.medicare.repository.RoleRepository;
import com.example.medicare.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class UserServiceImplementation implements UserService {

    @Autowired private UserRepository userRepository;

    @Autowired private RoleRepository roleRepository;

    @Autowired private ModelMapper modelMapper;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        Role role = this.roleRepository.searchRoleById(502);
        user.getRoles().add(role);
        User user1 = this.userRepository.save(user);
        UserDto userDto1 = this.modelMapper.map(user1, UserDto.class);
        return userDto1;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = this.userRepository.searchUserById(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        User user1 = this.userRepository.save(user);
        UserDto userDto1 = this.modelMapper.map(user1, UserDto.class);
        return userDto1;
    }
}
