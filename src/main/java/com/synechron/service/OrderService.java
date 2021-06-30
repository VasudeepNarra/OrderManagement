package com.synechron.service;

import com.synechron.modal.Order;
import com.synechron.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
       return orderRepository.save(order);
    }

    public List<Order> saveOrders(List<Order> orders){
        return orderRepository.saveAll(orders);
    }

    public Order getOrderById(int id){
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderByName(String name){
        return orderRepository.findByOrderName(name);
    }

    public String deleteOrder(int id){
        orderRepository.deleteById(id);
        return "product removed"+id;
    }

    public Order updateOrder(Order order){
        Order existingOrder = orderRepository.findById(order.getOrderId()).orElse(null);
        existingOrder.setOrderName(order.getOrderName());
        existingOrder.setOrderAmount(order.getOrderAmount());
        return orderRepository.save(existingOrder);
    }

}
