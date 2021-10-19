package com.niit.springsmartaccessories.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class AuthController {

    @RolesAllowed("USER")
    @RequestMapping("/*")
    public String getUser() {
        return "Welcome User";
    }

    @RolesAllowed({"ADMIN", "USER"})
    @RequestMapping("/admin")
    public String getAdmin() {
        return "Welcome Admin";
    }
}
