package com.nemesis.training.entity;

import com.nemesis.training.types.Phone;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String address;

    private Phone phone;
}
