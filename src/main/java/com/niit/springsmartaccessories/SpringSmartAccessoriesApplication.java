package com.niit.springsmartaccessories;

import com.niit.springsmartaccessories.services.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringSmartAccessoriesApplication implements CommandLineRunner {

    @Resource
    StorageService storageService;

    public static void main(String[] args) {
        SpringApplication.run(SpringSmartAccessoriesApplication.class, args);
    }

    @Override
    public void run(String... arg) {
        try {
            storageService.init();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
