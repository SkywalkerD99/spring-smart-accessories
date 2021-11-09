package com.niit.springsmartaccessories.dto;

import java.time.LocalDateTime;

public class ShipOrderDto {

    private long id;
    private long cartId;
    private LocalDateTime deliveryDate;

    public ShipOrderDto(long id, long cartId, LocalDateTime deliveryDate) {
        this.id = id;
        this.cartId = cartId;
        this.deliveryDate = deliveryDate;
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

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
