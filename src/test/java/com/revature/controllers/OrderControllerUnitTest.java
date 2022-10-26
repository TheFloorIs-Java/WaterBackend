package com.revature.controllers;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.models.Order;
import com.revature.services.OrderService;

class AccountControllerUnitTest {
    @Test
    public void getOrdersByUserEmailTest() {
        ArrayList<Order> orders = new ArrayList<Order>();
        OrderService os = Mockito.mock(OrderService.class);
        OrderController ac = new OrderController(os);

        Mockito.when(os.getOrdersByUserEmail("testuser@gmail.com")).thenReturn(orders);

        Assertions.assertEquals(orders, ac.getOrdersByUserEmail("testuser@gmail.com"));
        Mockito.verify(os).getOrdersByUserEmail("testuser@gmail.com");
    }
}