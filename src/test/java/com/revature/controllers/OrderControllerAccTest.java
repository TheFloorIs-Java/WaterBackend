package com.revature.controllers;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.revature.models.Order;
import com.revature.models.User;
import com.revature.utils.ObjToJSON;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class OrderControllerAccTest { // Acceptance test
    @Autowired
    private MockMvc mvc;

    @Test
    public void getOrdersByUserEmailTest() {
        User user = new User();
        user.setEmail("testdemo@gmail.com");

        String userJSON =  ObjToJSON.JSONify(user);

        RequestBuilder postUser = MockMvcRequestBuilders.post("/auth/register")
        .content(userJSON)
        .contentType(MediaType.APPLICATION_JSON);

        ArrayList<Order> orders = new ArrayList<Order>();

        Order order1 = new Order();
        order1.setUser(user);

        Order order2 = new Order();
        order2.setUser(user);

        orders.add(order1);
        orders.add(order2);
        
        String order1JSON = ObjToJSON.JSONify(order1);

        RequestBuilder postOrder1 = MockMvcRequestBuilders.post("/orders")
        .content(order1JSON)
        .contentType(MediaType.APPLICATION_JSON);

        String order2JSON = ObjToJSON.JSONify(order2);

        RequestBuilder postOrder2 = MockMvcRequestBuilders.post("/orders")
        .content(order2JSON)
        .contentType(MediaType.APPLICATION_JSON);

        String ordersJSON = ObjToJSON.JSONify(orders);

        RequestBuilder request = MockMvcRequestBuilders.get("/testdemo@gmail.com/orders")
            .contentType(MediaType.APPLICATION_JSON);

        try {
            this.mvc.perform(postUser);
            this.mvc.perform(postOrder1);
            this.mvc.perform(postOrder2);
            this.mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(ordersJSON));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}