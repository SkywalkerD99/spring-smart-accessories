package com.niit.springsmartaccessories.models;

import org.springframework.data.util.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ShipOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private Cart cart;

    private LocalDateTime orderDate;

    @Transient
    private long total;

    private Instant created;

    public ShipOrder(Cart cart, LocalDateTime orderDate) {
        this.cart = cart;
        this.orderDate = orderDate;
        this.created = Instant.now();

        long orderTotal = 0;
        for (LineItem li: cart.getLineItems())
            orderTotal = orderTotal + li.getTotal();
    }

    public ShipOrder() {
    }

    public long getShipOrderId() {
        return shipOrderId;
    }

    public void setShipOrderId(long shipOrderId) {
        this.shipOrderId = shipOrderId;
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
