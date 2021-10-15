package com.niit.springsmartaccessories.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotEmpty(message = "Firstname is required!")
    private String firstname;

    @NotEmpty(message = "Lastname is required!")
    private String lastname;

    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    private String address;



}
