package com.kr.poc.userservice.controller;


import com.kr.poc.userservice.entity.User;
import com.kr.poc.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/api/v1/")
public class UserServiceController {

   private WebClient webClient;

    @Autowired
    private UserRepository userRepository;

   public UserServiceController(){
        this.webClient= WebClient.builder()
                .baseUrl("http://localhost:7070")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();;
        ///this.userRepository=userRepository;
    }

    @GetMapping("/displayMessage")
    public Mono<String> displayMessage(){
        Mono<String> message=webClient.get()
                .uri("/CommonService/api/v1/printHello")
                .retrieve()
                .bodyToMono(String.class);

        System.err.println(message);
        return  message;
    }

    @GetMapping("/getUserInfoList")
    public Flux<User>getUserInfoList(){
        log.info("<<<<< STARTED & INSIDE UserServiceController ==> getUserInfoList >>>>>>>");
        Flux<User> userList = userRepository.findAll();
        log.info("<<<<< EXITING UserServiceController ==> getUserInfoList >>>>>>>");
        return userList;
                //ResponseEntity.status(HttpStatus.OK).body(userList);
    }
}
