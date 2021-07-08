package com.synechron.controllers;

import com.synechron.modal.Order;
import com.synechron.modal.OrderRequest;
import com.synechron.modal.OrderResponse;
import com.synechron.modal.User;
import com.synechron.repository.OrderRepository;
import com.synechron.repository.UserRepository;
import com.synechron.service.OrderService;
import com.synechron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    //Logger log = LoggerFactory.getLogger(OrderController.class);
/*
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/placeOrder")
    public User placeOrder(@RequestBody OrderRequest request){
        return userRepository.save(request.getUser());
    }

    @GetMapping("/findAllOrders")
    public List<User> findAllOrders(){
        return userRepository.findAll();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return userRepository.getJoinInformation();
    }
*/
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        //log.debug("Request {}", order);
        return orderService.saveOrder(order);
    }

    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> orders){
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
