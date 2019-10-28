package com.san.hospitalsystem.service;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Token;
import com.san.hospitalsystem.entity.User;

public interface IUserService {
  ServerResponse<Token> register(User user);
  ServerResponse<User> getUserInfo(String username);
  ServerResponse<User> updateUser(User user);

  ServerResponse<String> login(User user);
  ServerResponse<Boolean>  logout(User user);

  ServerResponse<Boolean> validToken(String tokenId); // 登录过期了么
  ServerResponse<String> updateToken(String tokenId);
}
