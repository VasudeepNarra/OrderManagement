package com.synechron.controllers;

import com.synechron.exceptions.RecordNotFoundException;
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
}