package com.nemesis.training.entity;

import com.nemesis.training.types.Price;

import jakarta.persistence.*;

@Entity
@Table(name = "lineitems")
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // FK order_id
    @ManyToOne(optional=false, fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    // FK product_id
    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @Column(columnDefinition = "Integer")
    private Integer quantity;

    @Column(columnDefinition = "VARCHAR(55)")
    private Price totalPrice;

    @Column(columnDefinition = "CHAR(3)")
    private String currency;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = new Price(totalPrice);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
