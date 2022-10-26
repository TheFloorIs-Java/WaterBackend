package com.revature.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.revature.ECommerceApplication;
import com.revature.dtos.LoginRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.utils.ObjToJSON;

/*
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderControllerAccTest { // Acceptance test
    @Autowired
    private MockMvc mvc;

    @Test
    public void getOrdersByUserEmail() {
        RegisterRequest register = new RegisterRequest();
        register.setEmail("ttttttt@gmail.com");
        register.setPassword("password");
        String registerJSON = ObjToJSON.JSONify(register);
        RequestBuilder registerPost = MockMvcRequestBuilders.post("/auth/register")
            .content(registerJSON)
            .contentType(MediaType.APPLICATION_JSON);

        LoginRequest login = new LoginRequest();
        login.setEmail("ttttttt@gmail.com");
        login.setPassword("password");
        String loginJSON = ObjToJSON.JSONify(login);
        RequestBuilder loginPost = MockMvcRequestBuilders.post("/auth/login")
            .content(loginJSON)
            .contentType(MediaType.APPLICATION_JSON);

        User user = new User();
        user.setEmail("ttttttt@gmail.com");
        ArrayList<Order> orders = new ArrayList<Order>();
        Order order1 = new Order();
        Order order2 = new Order();
        order1.setUser(user);
        order2.setUser(user);

        String order1JSON = ObjToJSON.JSONify(order1);
        RequestBuilder postOrder1 = MockMvcRequestBuilders.post("/orders")
            .content(order1JSON)
            .contentType(MediaType.APPLICATION_JSON);

        String order2JSON = ObjToJSON.JSONify(order2);
        RequestBuilder postOrder2 = MockMvcRequestBuilders.post("/orders")
            .content(order2JSON)
            .contentType(MediaType.APPLICATION_JSON);

        orders.add(order1);
        orders.add(order2);

        String ordersJSON = ObjToJSON.JSONify(ResponseEntity.ok(orders));
        RequestBuilder getOrders = MockMvcRequestBuilders.get("/ttttttt@gmail.com/orders")
            .contentType(MediaType.APPLICATION_JSON);

        try {
            this.mvc.perform(registerPost)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
            this.mvc.perform(loginPost)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
            this.mvc.perform(postOrder1)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
            this.mvc.perform(postOrder2)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
            this.mvc.perform(getOrders)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().json(ordersJSON));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/