package com.niit.springsmartaccessories.models;

import javax.persistence.*;
import java.time.Instant;

@Entity(name = "orders")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public User user;

    private Instant created;
    private boolean isActive;

    public Cart(User user, boolean isActive) {
        this.user = user;
        this.created = Instant.now();
        this.isActive = isActive;
    }

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
