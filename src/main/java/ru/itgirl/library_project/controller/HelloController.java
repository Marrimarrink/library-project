package ru.itgirl.library_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "It's works!";
    }

    @GetMapping("/hello2")
    public String sayHelloTwo() {
        return "It's works2!";
    }
}
