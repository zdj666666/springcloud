package com.zero.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication  extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EurekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
