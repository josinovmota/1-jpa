package com.nemesis.training.dao;

import com.nemesis.training.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer>{

    private final EntityManager em;

    public CustomerDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<Customer> get(long id) {
        // em.find()
        return Optional.empty();
    }

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public void save(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void update(Customer customer, String[] params) {
        // em.merge()
    }

    @Override
    public void delete(Customer customer) {
        // em.remove()

    }
}
