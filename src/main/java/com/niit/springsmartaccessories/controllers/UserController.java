package com.niit.springsmartaccessories.controllers;

import com.niit.springsmartaccessories.dto.UserDto;
import com.niit.springsmartaccessories.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

}
