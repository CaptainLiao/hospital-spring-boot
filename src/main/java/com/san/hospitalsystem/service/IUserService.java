package com.san.hospitalsystem.service;

import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.User;

public interface IUserService {
  ServerResponse register(User user);
  ServerResponse<User> update(User user);

  ServerResponse<String> login(User user);
  ServerResponse<Boolean> logout(User user);

  ServerResponse<Boolean> validToken(String tokenId); // 登录过期了么
  ServerResponse<String> updateToken(String tokenId);
}
