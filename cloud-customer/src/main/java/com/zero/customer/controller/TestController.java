package com.zero.customer.controller;

import com.zero.customer.feignclient.test.TestApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestApiClient testApiClient;

    @GetMapping("/test")
    public String test() {
        return testApiClient.test();
    }
}
