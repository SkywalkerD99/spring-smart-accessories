package com.niit.springsmartaccessories.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lineitemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product;

    @NotNull
    private Integer quantity;

    @Transient
    private long total;

    public LineItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total = (long)(quantity * product.getUnitPrice());
    }

    public LineItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
