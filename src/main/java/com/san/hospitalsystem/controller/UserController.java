package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.User;
import com.san.hospitalsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private IUserService userService;

  // Content-Type: x-www-form-urlencoded
  @PostMapping("/register")
  public ServerResponse register(String password, String username, HttpServletResponse response) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    response.setHeader("HttpOnly", String.valueOf(true));

    return userService.register(user);
  }

  // Content-Type: application/json
  @PostMapping("/register2")
  public ServerResponse register(@RequestBody User user) {
    return userService.register(user);
  }

  @PostMapping("/login")
  public ServerResponse login(@RequestBody User user) {
    return userService.login(user);
  }
}
