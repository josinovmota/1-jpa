package com.nemesis.training;

import com.nemesis.training.dao.OrderDao;
import com.nemesis.training.entity.Customer;
import com.nemesis.training.entity.LineItem;
import com.nemesis.training.entity.Order;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;


public class App {

    public static Order createOrderWithCustomerAndItems(EntityManagerFactory emf, Customer customer, List<LineItem> items) {
        OrderDao orderDao = new OrderDao(emf);

        Order order = new Order();
        order.setCustomer(customer);

        for (LineItem item : items) {
            order.addLineItem(item);
        }

        orderDao.save(order);

        return order;
    }

    public static List<LineItem> searchAnOrderForLineItems(EntityManagerFactory emf, Long id) {
        OrderDao orderDao = new OrderDao(emf);

        List<LineItem> itens = orderDao.findLineItemsByOrderId(id);

        return itens;
    }

    public static List<Order> findCustomerByNameAndPartOfAddress(EntityManagerFactory emf, String name, String addressPart) {
        OrderDao orderDao = new OrderDao(emf);

        List<Order> orders = orderDao.findOrdersByCustomerNameAndAddress(name, addressPart);

        return orders;
    }

    public static void removeAnOrder(EntityManagerFactory emf, Long id) {
        OrderDao orderDao = new OrderDao(emf);

        orderDao.deleteById(id);
    }
}