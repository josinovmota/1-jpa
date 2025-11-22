package com.nemesis.training.entity;

import com.nemesis.training.types.Price;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(columnDefinition = "VARCHAR(255)")
    private String description;

    private Price price;

    @Column(columnDefinition = "CHAR(3)")
    private String currency;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems = new ArrayList<>();

    public void setPrice(String Price) {
        this.price = new Price(Price);
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
