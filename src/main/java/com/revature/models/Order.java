package com.revature.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    // User
    @ManyToOne
    @JoinColumn
    private User user;

    // Billing
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    // Payment
    private String lastDigitsCardNo;

    // Cost
    private double costOfItems;
    private double costOfShipping;
    private double tax;
    private double totalCost;

    // Date
    private LocalDate date;

    // Order items
    @OneToMany
    @JsonManagedReference
    private List<OrderItem> items;
}