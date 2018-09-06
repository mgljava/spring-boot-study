package com.github.mgljava.service;

import com.github.mgljava.config.BookConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Autowired
  private BookConfiguration bookConfiguration;

  public String getData(String word) {
    return "Service " + word + ", Book Info: " + bookConfiguration;
  }
}
