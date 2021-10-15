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
}
