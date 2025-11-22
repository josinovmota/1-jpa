package com.nemesis.training.dao;

import com.nemesis.training.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Product> {

    private final EntityManager em;

    public ProductDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<Product> get(long id) {
        Product result = em.find(Product.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("FROM Product", Product.class).getResultList();
    }

    @Override
    public void save(Product product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public void update(Product product, String[] params) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
}
