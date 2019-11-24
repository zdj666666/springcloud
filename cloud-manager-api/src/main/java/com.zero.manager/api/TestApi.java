package com.zero.manager.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface TestApi {
    @GetMapping("/test")
    String test();
}
