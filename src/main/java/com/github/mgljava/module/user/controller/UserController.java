package com.github.mgljava.module.user.controller;

import com.github.mgljava.module.user.domain.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

  static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

  @GetMapping(value = "/")
  public List<User> getUsers() {
    List<User> users = new ArrayList<>(userMap.values());
    return users;
  }

  @PostMapping(value = "/")
  public String postUser(@ModelAttribute User user) {
    userMap.put(user.getId(), user);
    return "success";
  }

  @GetMapping(value = "/{id}")
  public User getUserById(@PathVariable Long id) {
    return userMap.get(id);
  }

  @PutMapping(value = "/{id}")
  public String putUser(@PathVariable Long id, @ModelAttribute User user) {
    User updateUser = userMap.get(id);
    updateUser.setName(user.getName());
    updateUser.setAge(user.getAge());
    userMap.put(id, updateUser);
    return "success";
  }

  @DeleteMapping(value = "/{id}")
  public String deleteUser(@PathVariable Long id) {
    userMap.remove(id);
    return "success";
  }
}
