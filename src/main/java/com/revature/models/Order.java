package com.revature.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

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
    @Column(name = "order_id")
    private int orderID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "group_id")
    private int groupID;
    private String productName;
    private String productImage;
    @Column(length = 500)
    private String productDescription;
    private double productPrice;
    private int productQuantity;
    private LocalDate date;
}

/* JSON body example for a post request:
 *
 * [
 *  {
 *      "user": {"id": 1},
 *      "productName": "shirt",
 *      "productImage": "image",
 *      "productDescription": "merch",
 *      "productPrice": 22.2,
 *      "productQuantity": 4
 *  }
 * ]
 */