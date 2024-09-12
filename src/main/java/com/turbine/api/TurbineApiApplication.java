package com.turbine.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TurbineApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApiApplication.class, args);
    }

}
