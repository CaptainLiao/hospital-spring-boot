package com.san.hospitalsystem.controller;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Token;
import com.san.hospitalsystem.entity.User;
import com.san.hospitalsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private IUserService userService;

  @PostMapping("/register")
  public ServerResponse<Token> register(String username, String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);

    return userService.register(user);
  }
}
