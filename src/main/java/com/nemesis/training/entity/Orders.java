package com.nemesis.training.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItem = new ArrayList<>();

}
