package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.revature.models.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    /**
     * Retrieves all items from the database of a single order
     * 
     * @param orderID must correspond to an order in the database
     * @return all items from the database of a single order
     */
    @Query(value = "SELECT * FROM Order_Items WHERE order_id = :order_id", nativeQuery = true)
    public List<OrderItem> getOrderItemsByOrderID(@Param("order_id") int orderID);
}