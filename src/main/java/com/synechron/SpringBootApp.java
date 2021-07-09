package com.synechron;

import com.synechron.modal.User;
import com.synechron.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootApp {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "vasudeep", "password", "vasudeepnarra@gmail.com","9490778732",null),
                new User(102, "user1", "pwd1", "user1@gmail.com","9490778732",null),
                new User(103, "user2", "pwd2", "user2@gmail.com","9490778732",null),
                new User(104, "user3", "pwd3", "user3@gmail.com","9490778732",null)
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args){
        SpringApplication.run(SpringBootApp.class);
        System.out.println("Server Started...");
    }
}
