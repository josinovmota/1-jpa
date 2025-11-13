package com.nemesis.training.dao;

import com.nemesis.training.entity.Orders;

import java.util.List;
import java.util.Optional;

public class OrderDao implements Dao<Orders>{

    @Override
    public Optional<Orders> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Orders> getAll() {
        return List.of();
    }

    @Override
    public void save(Orders orders) {

    }

    @Override
    public void update(Orders orders, String[] params) {

    }

    @Override
    public void delete(Orders orders) {

    }
}
