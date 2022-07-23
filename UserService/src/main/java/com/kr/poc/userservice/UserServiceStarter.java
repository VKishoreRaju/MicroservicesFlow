package com.kr.poc.userservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableJpaRepositories("com.kr.poc.userservice.repository")
//@EnableR2dbcRepositories(basePackages ="com.kr.poc.userservice.repository")
//@EnableTransactionManagement
@Slf4j
public class UserServiceStarter {

    public static void main(String[] args) {
        log.info("<<<< UserServiceStarter===>main>>>>>>>> ");
        SpringApplication.run(UserServiceStarter.class);
    }
}
