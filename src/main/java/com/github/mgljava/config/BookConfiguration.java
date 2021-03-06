package com.github.mgljava.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@ToString
@Component
@PropertySource(value = {"classpath:application.yml"})
@ConfigurationProperties(prefix = "book")
public class BookConfiguration {

  @Value("${name}")
  private String name;
  @Value("${author}")
  private String author;
  @Value("${desc}")
  private String desc;
}
