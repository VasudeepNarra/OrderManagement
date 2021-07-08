package com.synechron.repository;

import com.synechron.modal.OrderResponse;
import com.synechron.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
    //@Query("SELECT new com.synechron.modal.OrderResponse(user.userName , order.orderName) FROM User user JOIN user.orders order")
    //public List<OrderResponse> getJoinInformation();
}
