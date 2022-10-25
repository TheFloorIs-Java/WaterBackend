package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Order_Items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne
    @JsonBackReference
    @JoinColumn
    private Order order;

    // Not using a foreign key to products for the following information just in case the product is discontinued or details are changed
    private String productName;
    private String productImage;
    private String productDescription;
    private double productPrice;
    private int productQuantity;
}