package com.nemesis.training.entity;

import com.nemesis.training.types.Price;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    private List<Product> product = new ArrayList<>();
}
