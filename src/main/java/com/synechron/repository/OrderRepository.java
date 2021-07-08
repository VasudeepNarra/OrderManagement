package com.synechron.repository;

import com.synechron.modal.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByOrderName(String name);
    @Query(value = "SELECT * FROM ordermgmt.orders o where o.user_id = :uid", nativeQuery = true)
    List<Order> getOrderByUser(@Param("uid") int uid);
}
