package com.niit.springsmartaccessories.repositories;

import com.niit.springsmartaccessories.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
