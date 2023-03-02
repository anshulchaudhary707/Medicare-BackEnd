package com.example.medicare.repository;

import com.example.medicare.module.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role searchRoleById(int id);
}
