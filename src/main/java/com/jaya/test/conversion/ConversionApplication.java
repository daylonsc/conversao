package com.jaya.test.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.jaya.test.conversion.client")
@SpringBootApplication
public class ConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConversionApplication.class, args);
    }

}
