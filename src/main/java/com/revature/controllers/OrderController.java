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
@CrossOrigin(origins = {"https://teamwaterfrontend.azurewebsites.net", "http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class OrderController {
    private OrderService os;

    @Autowired
    public OrderController(OrderService os) {
        this.os = os;
    }

    /**
     * Saves an order made by a user
     * 
     * @param order is an order made by a user
     */
    @Authorized
    @PostMapping("orders")
    public ResponseEntity<Order> submitOrder(@RequestBody Order order) {
        return ResponseEntity.ok(this.os.submitOrder(order));
    }

    /**
     * Retrieves all orders of a single user
     * 
     * @param userEmail must correspond to a user
     * @return all orders of a single user
     */
    @Authorized
    @GetMapping("{user_email}/orders")
    public ResponseEntity<List<Order>> getOrdersByUserEmail(@PathVariable("user_email") String userEmail) {
        return ResponseEntity.ok(this.os.getOrdersByUserEmail(userEmail));
    }
}