package com.niit.springsmartaccessories.services;

import com.niit.springsmartaccessories.dto.UserDto;
import com.niit.springsmartaccessories.models.User;
import com.niit.springsmartaccessories.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserDto userDto) {
        for (User usr: userRepository.findAll())
            if (userDto.getEmail().equals(usr.getEmail()))
                throw new RuntimeException("User with email: " + usr.getEmail() + "already exists!");

        userRepository.save(new User(userDto.getFirstname(), userDto.getLastname(), userDto.getEmail(), userDto.getAddress()));
    }
}
