package com.example.medicare.repository;

import com.example.medicare.module.Cart;
import com.example.medicare.module.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    List<Cart> findByUser(User user);
    void deleteByUser(User user);
}
