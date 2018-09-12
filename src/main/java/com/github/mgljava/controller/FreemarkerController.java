package com.github.mgljava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreemarkerController {

  @GetMapping("/free")
  public String hello() {
    return "hello";
  }
}
