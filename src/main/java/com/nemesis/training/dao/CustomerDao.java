package com.nemesis.training.dao;

import com.nemesis.training.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class CustomerDao implements Dao<Customer>{

    private final EntityManager em;

    public CustomerDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<Customer> get(long id) {
        Customer result = em.find(Customer.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public List<Customer> getAll() {
        return em.createQuery("FROM Customer", Customer.class).getResultList();
    }

    @Override
    public void save(Customer customer) {
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }

    @Override
    public void update(Customer customer, String[] params) {
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Customer customer) {
        em.getTransaction().begin();
        em.remove(customer);
        em.getTransaction().commit();

    }
}
