package com.jaya.test.conversao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.jaya.test.conversao.client")
@SpringBootApplication
public class ConversaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConversaoApplication.class, args);
    }

}
