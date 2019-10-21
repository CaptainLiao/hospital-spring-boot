package com.san.hospitalsystem.service.impl;

import com.san.hospitalsystem.entity.Token;
import com.san.hospitalsystem.entity.User;
import com.san.hospitalsystem.service.IUserService;

public class UserServiceImpl implements IUserService {

  @Override
  public User register(User user) {
    return null;
  }

  @Override
  public User updateUser(User user) {
    return null;
  }

  @Override
  public Token login(User user) {
    return null;
  }

  @Override
  public boolean logout(User user) {
    return false;
  }

  @Override
  public boolean validSession(String sessionId) {
    return false;
  }

  @Override
  public Token updateSession(String sessionId) {
    return null;
  }
}
