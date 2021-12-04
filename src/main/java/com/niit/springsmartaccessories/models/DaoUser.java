package com.niit.springsmartaccessories.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class DaoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column
    @NotEmpty(message = "Username cannot be empty!")
    private String username;

    @Column
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    @Column
    @NotEmpty(message = "Password cannot be empty!")
    private String password;

    @Column
    private String role;

    public DaoUser(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public DaoUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
