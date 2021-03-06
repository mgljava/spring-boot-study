package com.github.mgljava.module.user.controller;

import com.github.mgljava.module.user.domain.User;
import com.github.mgljava.module.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController {

  private final UserService userService;

  @ApiOperation(value = "获取用户列表")
  @GetMapping(value = "/")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  @PostMapping(value = "/")
  public String postUser(@ModelAttribute User user) {
    userService.postUser(user);
    return SUCCESS;
  }

  @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
  @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
  @GetMapping(value = "/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
  @ApiImplicitParams( {
      @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
      @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
  })
  @PutMapping(value = "/{id}")
  public String putUser(@PathVariable Long id, @ModelAttribute User user) {
    userService.putUser(id, user);
    return SUCCESS;
  }

  @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
  @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
  @DeleteMapping(value = "/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return SUCCESS;
  }
}
