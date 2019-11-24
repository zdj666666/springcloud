package com.zero.customer.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.zero.customer.feignclient")
public class FeignClientConfiguration {
}
