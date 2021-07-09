package com.synechron.controllers;

import com.synechron.exceptions.RecordNotFoundException;
import com.synechron.modal.Order;
import com.synechron.modal.OrderRequest;
import com.synechron.modal.OrderResponse;
import com.synechron.modal.User;
import com.synechron.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Swagger2UserRestController", description = "This REST Api related to Welcome Message!!!!")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User user1 = userService.addUser(user);
        if (user1 == null) {
            throw new RecordNotFoundException("User is not created : "+user);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/User/{id}")
    public User findUserById(@PathVariable int id){
        return userService.findByUserId(id);
    }

    @GetMapping("/Users/{name}")
    public User findUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }


    @PostMapping("/placeOrder")
    public User placeOrder(@RequestBody OrderRequest request){
        return userService.placeOrder(request.getUser());
    }

    @GetMapping("/findAllOrders")
    public List<User> findAllOrders(){
        return userService.findAllOrders();
    }

    @GetMapping("/getInfo")
    public List<OrderResponse> getJoinInformation(){
        return userService.getJoinInformation();
    }
}