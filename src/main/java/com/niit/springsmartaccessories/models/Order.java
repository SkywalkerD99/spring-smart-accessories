package com.niit.springsmartaccessories.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private Cart cart;

    private LocalDateTime orderDate;

    @NotNull
    private long total;

    private Instant created;

    public Order(Cart cart, LocalDateTime orderDate, long total) {
        this.cart = cart;
        this.orderDate = orderDate;
        this.total = total;
        this.created = Instant.now();
    }

    public Order() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
