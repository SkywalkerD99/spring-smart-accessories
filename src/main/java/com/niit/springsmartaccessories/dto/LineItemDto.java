package com.niit.springsmartaccessories.dto;

import com.niit.springsmartaccessories.models.Product;

public class LineItemDto {

    private long id;
    private long productId;
    private long cartId;
    private int quantity;

    public LineItemDto(long id, long productId, long cartId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.cartId = cartId;
        this.quantity = quantity;
    }

    public LineItemDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
