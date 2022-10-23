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
     * Retrieves all orders of a single user from the database based on the user's email
     * 
     * @param userEmail must be valid
     * @returns all orders of a single user
     */
    @Query(value = "SELECT Orders.* FROM Orders INNER JOIN Users ON Orders.user_id = Users.id WHERE Users.email = :user_email", nativeQuery = true)
    public List<Order> getOrdersByUserEmail(@Param("user_email") String userEmail);

    /**
     * Retrieves a group of orders from the database based on the group ID of the orders
     * @param groupID must be valid
     * @returns a group of orders
     */
    @Query(value = "SELECT * FROM Orders WHERE group_id = :group_id", nativeQuery = true)
    public List<Order> getOrdersByGroupID(@Param("group_id") int groupID);
}