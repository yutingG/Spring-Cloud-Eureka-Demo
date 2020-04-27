package com.dewi.consumer.controller;

import com.dewi.consumer.model.User;
import com.dewi.consumer.remote.UserRemote;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/26 8:54 PM
 */
@RestController
public class MovieController {

//    /**
//     * RestTemplate写法
//     */
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @GetMapping(value = "/user/{id}")
//    public User findById(@PathVariable Integer id) {
//        return this.restTemplate.getForObject("http://localhost:8080/user/" + id, User.class);
//    }

    /**
     * Feign用法
     */
    @Autowired
    UserRemote userRemote;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @RequestMapping(value = "/user/{id}")
    public User findById(@PathVariable(value = "id") Integer id) {
        return this.userRemote.findById(id);
    }

    public User getDefaultUser(Integer id) {
        System.out.println("熔断，默认回调函数");
        User user = new User();
        user.setId(-1);
        user.setName("熔断用户");
        user.setAge(100);
        return user;
    }

}
