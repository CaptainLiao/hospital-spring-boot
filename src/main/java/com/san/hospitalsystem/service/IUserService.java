package com.san.hospitalsystem.service;

import com.san.hospitalsystem.entity.Token;
import com.san.hospitalsystem.entity.User;

public interface IUserService {
  User register(User user);
  User updateUser(User user);

  Token login(User user);
  boolean logout(User user);

  boolean validSession(String sessionId); // 登录过期了么
  Token updateSession(String sessionId);
}
