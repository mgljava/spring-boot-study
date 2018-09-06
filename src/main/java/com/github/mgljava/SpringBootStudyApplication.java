package com.github.mgljava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.mgljava.domain")
public class SpringBootStudyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootStudyApplication.class, args);
  }
}
