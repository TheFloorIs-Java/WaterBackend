package com.revature.controllers;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.revature.models.Order;
import com.revature.services.OrderService;
import com.revature.utils.ObjToJSON;

@WebMvcTest(OrderController.class)
public class OrderControllerIntTest { // Integration test
    @Autowired
    private MockMvc mvc;
    @MockBean
    private OrderService os;

    @Test
    public void signUp() {
        ArrayList<Order> orders = new ArrayList<Order>();
        String ordersJSON = ObjToJSON.JSONify(orders);

        Mockito.when(this.os.getOrdersByUserEmail("testuser@gmail.com")).thenReturn(orders);

        RequestBuilder request = MockMvcRequestBuilders.get("/testuser@gmail.com/orders")
            .contentType(MediaType.APPLICATION_JSON);

        try {
            this.mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(ordersJSON));

            Mockito.verify(this.os).getOrdersByUserEmail("testuser@gmail.com");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}