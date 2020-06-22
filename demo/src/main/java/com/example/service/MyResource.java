package com.example.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyResource {

    @GetMapping("hi")
    public String greet() {
        return "Hello World";
    }
}


