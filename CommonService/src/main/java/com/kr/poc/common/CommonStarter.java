package com.kr.poc.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CommonStarter {
    public static void main(String[] args) {
        SpringApplication.run(CommonStarter.class);

    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
