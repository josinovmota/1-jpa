package com.nemesis.training.entity;

import com.nemesis.training.types.TotalPrice;

import javax.persistence.*;

@Entity
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // FK order_id
    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false)
    private Orders orders;

    // FK product_id
    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    @Column(columnDefinition = "Integer")
    private Integer quantity;

    private TotalPrice total_price;

    @Column(columnDefinition = "CHAR(3)")
    private String currency;
}
