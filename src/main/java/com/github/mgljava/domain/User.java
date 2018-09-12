package com.github.mgljava.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: SweepMonk date: 2018年9月12日21:09:03 desc: User实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private String username;
  private Integer age;
}
