package com.dewi.consumer.remote;

import com.dewi.consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "eureka-provider")
public interface UserRemote {

    @RequestMapping(value = "/user/{id}")
    User findById(@RequestParam("id") Integer id);
}
