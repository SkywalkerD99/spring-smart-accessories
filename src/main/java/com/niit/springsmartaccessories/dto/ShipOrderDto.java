package com.niit.springsmartaccessories.dto;

import java.time.LocalDateTime;

public class ShipOrderDto {

    private long id;
    private long cartId;
    private LocalDateTime orderDate;

    public ShipOrderDto(long id, long cartId, LocalDateTime orderDate) {
        this.id = id;
        this.cartId = cartId;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
