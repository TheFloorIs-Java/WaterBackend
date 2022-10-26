package com.revature.controllers;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.revature.models.Order;
import com.revature.services.OrderService;

public class OrderControllerUnitTest {
    @Test
    public void getOrdersByUserEmailTest() {
        ArrayList<Order> orders = new ArrayList<Order>();
        Order order1 = new Order();
        Order order2 = new Order();
        orders.add(order1);
        orders.add(order2);

        OrderService os = Mockito.mock(OrderService.class);
        OrderController ac = new OrderController(os);

        Mockito.when(os.getOrdersByUserEmail("testuser@gmail.com")).thenReturn(orders);

        Assertions.assertEquals(ResponseEntity.ok(orders), ac.getOrdersByUserEmail("testuser@gmail.com"));
        Mockito.verify(os).getOrdersByUserEmail("testuser@gmail.com");
    }
}