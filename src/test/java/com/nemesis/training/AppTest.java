package com.nemesis.training;

import com.nemesis.training.dao.ProductDao;
import com.nemesis.training.entity.Customer;
import com.nemesis.training.entity.LineItem;
import com.nemesis.training.entity.Order;
import com.nemesis.training.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class AppTest {

    private EntityManagerFactory emf;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }


    @Test
    void mustCreateOrderWhenCustomerAndItemsAreGiven() {
        Customer customer = new Customer();
        customer.setName("Alex Soares");

        Product product1 = new Product();
        product1.setPrice("R$ 24,03");
        product1.setCurrency("BRL");

        ProductDao productDao = new ProductDao(emf);
        productDao.save(product1);

        LineItem item1 = new LineItem();
        item1.setProduct(product1);
        item1.setTotalPrice("R$ 216,27");
        item1.setCurrency("BRL");

        List<LineItem> items = List.of(item1);

        Order order = App.createOrderWithCustomerAndItems(emf, customer, items);

        EntityManager em = emf.createEntityManager();
        Order saved = em.find(Order.class, order.getId());

        Assertions.assertNotNull(saved);
    }

    public void testSearchAnOrderForLineItems() {

    }

    public void testFindCustomerByNameAndPartOfAddress() {
    }

    public void testRemoveAnOrder() {
    }
}