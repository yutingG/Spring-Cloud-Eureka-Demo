package com.dewi.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: guoyuting
 * @Date: Created at 2020/4/27 9:03 PM
 */
@RestController
public class HelloController {

    @Value("${neo.hello}")
    private String hello;

    @GetMapping(value = "/hello")
    public String hello() {
        return this.hello;
    }
}
