package com.nemesis.training.dao;

import com.nemesis.training.entity.Customer;
import com.nemesis.training.entity.LineItem;
import com.nemesis.training.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.*;

import java.util.List;
import java.util.Optional;

public class OrderDao implements Dao<Order> {

    private final EntityManager em;

    public OrderDao(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public Optional<Order> get(long id) {
        Order result = em.find(Order.class, id);
        return Optional.ofNullable(result);
    }

    @Override
    public List<Order> getAll() {
        return em.createQuery("FROM Order", Order.class).getResultList();
    }

    @Override
    public void save(Order order) {
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();

    }

    @Override
    public void update(Order order, String[] params) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Order order) {
        em.getTransaction().begin();
        em.remove(order);
        em.getTransaction().commit();
    }

    public List<LineItem> findLineItemsByOrderId(Long orderId) {
        try {
            Order order = em.find(Order.class, orderId);
            if(order == null) {
                // Log
                System.out.println("TODO");
            }

            return order.getLineItems();

        } finally {
            em.close();
        }
    }

    public List<Order> findOrdersByCustomerNameAndAddress(String name, String addressPart) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Order> cq = cb.createQuery(Order.class);

            Root<Order> orderRoot = cq.from(Order.class);

            Join<Order, Customer> customerJoin = orderRoot.join("customer");

            Predicate nameEquals = cb.equal(cb.lower(customerJoin.get("name")), name.toLowerCase());

            Predicate addressLike = cb.like(cb.lower(customerJoin.get("adress")), "%" + addressPart.toLowerCase() + "%");

            cq.select(orderRoot).where(cb.and(nameEquals, addressLike));

            return em.createQuery(cq).getResultList();

        } finally {
            em.close();
        }
    }

    public void deleteById(Long id) {
        try {
            em.getTransaction().begin();

            Order order = em.find(Order.class, id);

            if (order != null) {
                em.remove(order);
            }

            if (order == null) {
                throw new IllegalArgumentException("ERROR: Order with id: '" + id + "' don't exist");
            }

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

}
