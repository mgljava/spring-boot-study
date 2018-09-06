package com.example.demo.controller;

import com.example.demo.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;

  @GetMapping("/hello")
  public String sayHello(@RequestParam("word") String words) {
    String requestString = "Hello " + words;
    return helloService.getData(requestString);
  }

  @RequestMapping("/")
  public String sayHello() {
    return "Hello,World!";
  }
}
