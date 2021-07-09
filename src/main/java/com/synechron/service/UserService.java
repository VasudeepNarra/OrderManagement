package com.synechron.service;

import com.synechron.modal.Order;
import com.synechron.modal.OrderRequest;
import com.synechron.modal.User;
import com.synechron.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
                new ArrayList<>());
    }
    public User addUser(User user) {
        return repository.save(user);
    }

    public User findByUserId(int userId) {
        return repository.findById(userId).orElse(null);
    }
    public User getUserByName(String name){
        return repository.findByUserName(name);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    public String deleteUser(int id){
        repository.deleteById(id);
        return "user removed :-"+id;
    }

    public User updateUser(User user){
        User existingUser = repository.findById(user.getUserId()).orElse(null);
        existingUser.setUserId(user.getUserId());
        existingUser.setUserName(user.getUserName());
        existingUser.setUserPassword(user.getUserPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return repository.save(existingUser);
    }

    public User placeOrder(User user){
        return repository.save(user);
    }

    public List<User> findAllOrders(){
        return repository.findAll();
    }
}
