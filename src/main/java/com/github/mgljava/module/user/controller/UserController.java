package com.github.mgljava.module.user.controller;

import com.github.mgljava.module.user.domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

  private static final String SUCCESS = "success";

  static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

  @ApiOperation(value = "获取用户列表")
  @GetMapping(value = "/")
  public List<User> getUsers() {
    return new ArrayList<>(userMap.values());
  }

  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  @PostMapping(value = "/")
  public String postUser(@ModelAttribute User user) {
    userMap.put(user.getId(), user);
    return SUCCESS;
  }

  @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
  @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
  @GetMapping(value = "/{id}")
  public User getUserById(@PathVariable Long id) {
    return userMap.get(id);
  }

  @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
      @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  })
  @PutMapping(value = "/{id}")
  public String putUser(@PathVariable Long id, @ModelAttribute User user) {
    User updateUser = userMap.get(id);
    updateUser.setName(user.getName());
    updateUser.setAge(user.getAge());
    userMap.put(id, updateUser);
    return SUCCESS;
  }

  @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
  @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
  @DeleteMapping(value = "/{id}")
  public String deleteUser(@PathVariable Long id) {
    userMap.remove(id);
    return SUCCESS;
  }
}
