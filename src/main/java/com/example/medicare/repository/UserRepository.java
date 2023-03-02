package com.example.medicare.repository;

import com.example.medicare.module.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User searchUserById(int id);
    User searchUserByEmail(String email);
}
