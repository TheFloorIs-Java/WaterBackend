package com.revature.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Order;
import com.revature.repositories.OrderRepository;

@Service
public class OrderService {
    private OrderRepository or;
    
    @Autowired
    public OrderService(OrderRepository or) {
        this.or = or;
    }

    /**
     * Retrieves all orders of a single user from the database based on the user's email
     * 
     * @param userEmail must be valid
     * @returns all orders of a single user
     */
    @Transactional
    public List<Order> getOrdersByUserEmail(String userEmail) {
        return this.or.getOrdersByUserEmail(userEmail);
    }

    /**
     * Retrieves a group of orders from the database based on the group ID of the orders
     * 
     * @param groupID must be valid
     * @returns a group of orders
     */
    @Transactional
    public List<Order> getOrdersByGroupID(Integer groupID) {
        return this.or.getOrdersByGroupID(groupID);
    }

    /**
     * Inserts a group of orders corresponding to a single transaction into the database
     * 
     * @param orders must not be empty or null
     */
    @Transactional
    public void submitOrders(List<Order> orders) {
        this.or.saveAll(orders); // Saving beforehand in order to retrieve the first order's ID, which is only set after saving

        // The following changes reflect within the database even though "saveAll" is not called afterwards
        int orderID = orders.get(0).getOrderID();
        int groupID = 1;
        LocalDate now = LocalDate.now();

        // If the order ID is equal to 1, then leave the group ID equal to 1
        // If the order ID is greater than 1, then set the group ID equal to the group ID of the previous row plus 1
        if (orderID > 1) {
            groupID = this.or.findById(orderID - 1).get().getGroupID() + 1;
        }

        // All orders submitted within a single transaction must have the same group ID as well as the same date
        for (Order order : orders) {
            order.setGroupID(groupID);
            order.setDate(now);
        }
    }
}