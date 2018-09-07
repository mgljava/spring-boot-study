package com.github.mgljava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemarkerController {

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }
}
