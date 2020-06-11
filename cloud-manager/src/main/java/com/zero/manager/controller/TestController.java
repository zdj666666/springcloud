package com.zero.manager.controller;

import com.zero.manager.api.TestApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi {

    @Override
    public String test() {
        return "nqwe测试qweull";
    }
}
