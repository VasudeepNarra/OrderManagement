package com.synechron.controllers;

import com.synechron.modal.Order;
import com.synechron.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public Order addProduct(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @PostMapping("/addOrders")
    public List<Order> addProduct(@RequestBody List<Order> orders){
        return orderService.saveOrders(orders);
    }

    @GetMapping("/allOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/Order/{id}")
    public Order findOrderById(@PathVariable int id){
        return orderService.getOrderById(id);
    }
    @GetMapping("/Orders/{name}")
    public Order findOrderByName(@PathVariable String name){
        return orderService.getOrderByName(name);
    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }

}
