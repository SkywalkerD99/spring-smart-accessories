package com.niit.springsmartaccessories.repositories;

import com.niit.springsmartaccessories.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
