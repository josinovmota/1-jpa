package com.nemesis.training.entity;

import com.nemesis.training.types.Email;
import com.nemesis.training.types.Phone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "VARCHAR(150)")
    private String name;

    @Column(columnDefinition = "VARCHAR(150)")
    private String address;

    private Phone phone;

    private Email email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();
}