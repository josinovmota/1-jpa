package com.nemesis.training.dao;

import com.nemesis.training.entity.LineItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

public class LineItemDao implements Dao<LineItem> {

    private final EntityManager em;

    public LineItemDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<LineItem> get(long id) {
        LineItem result = em.find(LineItem.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public List<LineItem> getAll() {
        return em.createQuery("FROM LineItem ", LineItem.class).getResultList();
    }

    @Override
    public void save(LineItem lineItem) {
        em.getTransaction().begin();
        em.persist(lineItem);
        em.getTransaction().commit();
    }

    @Override
    public void update(LineItem lineItem, String[] params) {
        em.getTransaction().begin();
        em.merge(lineItem);
        em.getTransaction().commit();
    }

    @Override
    public void delete(LineItem lineItem) {
        em.getTransaction().begin();
        em.remove(lineItem);
        em.getTransaction().commit();
    }
}
