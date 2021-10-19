package com.niit.springsmartaccessories.dto;

public class CartDto {

    private long id;
    private long userId;
    private boolean active;

    public CartDto() {
    }

    public CartDto(long id, long userId, boolean active) {
        this.id = id;
        this.userId = userId;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }
}
