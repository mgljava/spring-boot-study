package com.github.mgljava.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class City {

  private Long id;
  private Long provinceId;
  private String cityName;
  private String description;
}
