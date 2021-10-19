package com.niit.springsmartaccessories.models;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long cartId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    public User user;

    private Instant created;

    @OneToMany(fetch = FetchType.LAZY)
    private List<LineItem> lineItems;

    private boolean active;

    public Cart(User user, boolean active) {
        this.user = user;
        this.created = Instant.now();
        this.active = active;
    }

    public Cart() {
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
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

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        active = active;
    }
}
