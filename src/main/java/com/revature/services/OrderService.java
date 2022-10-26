package com.revature.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Order;
import com.revature.models.OrderItem;
import com.revature.models.User;
import com.revature.repositories.OrderRepository;
import com.revature.repositories.OrderItemRepository;
import com.revature.repositories.UserRepository;

@Service
public class OrderService {
    private UserRepository ur;
    private OrderRepository or;
    private OrderItemRepository ir;
    
    @Autowired
    public OrderService(UserRepository ur, OrderRepository or, OrderItemRepository ir) {
        this.ur = ur;
        this.or = or;
        this.ir = ir;
    }

    /**
     * Saves an order made by a user
     * 
     * @param order is an order made by a user
     */
    @Transactional
    public Order submitOrder(Order order) {
        int userID = this.ur.getIDByEmail(order.getUser().getEmail());
        User user = this.ur.findById(userID).get();
        order.setUser(user); // Sets all information of the user rather than only having the email that's received in the HTTP request

        LocalDate now = LocalDate.now();
        order.setDate(now);
        
        this.or.save(order);

        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {
                item.setOrder(order);
                this.ir.save(item);
            }
        }

        return order;
    }

    /**
     * Retrieves all orders of a single user
     * 
     * @param userEmail must correspond to a user
     * @return all orders of a single user
     */
    @Transactional
    public List<Order> getOrdersByUserEmail(String userEmail) {
        return this.or.getOrdersByUserEmail(userEmail);
    }
}