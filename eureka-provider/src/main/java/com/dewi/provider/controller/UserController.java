package com.dewi.provider.controller;

import com.dewi.provider.dao.UserRepository;
import com.dewi.provider.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/26 8:29 PM
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }
}
