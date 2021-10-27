package com.niit.springsmartaccessories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String HelloWorld() {
        return "HelloWorld";
    }

}
