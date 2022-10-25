package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    /**
     * Retrieves all orders from the database of a single user
     * 
     * @param userEmail must correspond to a user in the database
     * @return all orders from the database of a single user
     */
    @Query(value = "SELECT Orders.* FROM Orders INNER JOIN Users ON Orders.user_id = Users.id WHERE Users.email = :user_email ORDER BY Orders.id DESC", nativeQuery = true)
    public List<Order> getOrdersByUserEmail(@Param("user_email") String userEmail);
}