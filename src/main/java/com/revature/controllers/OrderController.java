package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.annotations.Authorized;
import com.revature.models.Order;
import com.revature.services.OrderService;


@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class OrderController {
    private OrderService os;

    @Autowired
    public OrderController(OrderService os) {
        this.os = os;
    }

    /**
     * Retrieves all orders of a single user from the database based on the user's email
     * 
     * @param userEmail must be valid
     * @returns all orders of a single user
     */
    @Authorized
    @GetMapping("{user_email}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserEmail(@PathVariable("user_email") String userEmail) {
        return ResponseEntity.ok(this.os.getOrdersByUserEmail(userEmail));
    }

    /**
     * Retrieves a group of orders from the database based on the group ID of the orders
     * 
     * @param groupID must be valid
     * @returns a group of orders
     */
    @Authorized
    @GetMapping("orders/groups/{group_id}")
    public ResponseEntity<List<Order>> getOrdersByGroupID(@PathVariable("group_id") int groupID) {
        return ResponseEntity.ok(this.os.getOrdersByGroupID(groupID));
    }

    /**
     * Inserts a group of orders corresponding to a single transaction into the database
     * 
     * @param orders must not be empty or null
     */
    @Authorized
    @PostMapping("orders")
    public void submitOrders(@RequestBody List<Order> orders) {
        this.os.submitOrders(orders);
    }
}