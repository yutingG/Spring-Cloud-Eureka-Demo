package com.dewi.consumer.controller;

import com.dewi.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/26 8:54 PM
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Integer id) {
        return this.restTemplate.getForObject("http://localhost:8080/user/" + id, User.class);
    }
}
