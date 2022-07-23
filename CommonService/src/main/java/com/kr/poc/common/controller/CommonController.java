package com.kr.poc.common.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class CommonController {


    @GetMapping("/printHello")
    public String printHello(){
        return "Hi!!! This is Kishore!!";
    }
}
