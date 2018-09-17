package com.github.mgljava.module.user.service;

import com.github.mgljava.module.user.domain.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

  public List<User> getUsers() {
    return new ArrayList<>(userMap.values());
  }


  public void postUser(User user) {
    userMap.put(user.getId(), user);
  }

  public User getUserById(Long id) {
    return userMap.get(id);
  }

  public void putUser(Long id, User user) {
    User updateUser = userMap.get(id);
    updateUser.setName(user.getName());
    updateUser.setAge(user.getAge());
    userMap.put(id, updateUser);
  }

  public void deleteUser(Long id) {
    userMap.remove(id);
  }
}
