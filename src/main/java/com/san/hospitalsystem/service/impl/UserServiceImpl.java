package com.san.hospitalsystem.service.impl;

import com.san.hospitalsystem.Mapper.UserMapper;
import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.User;
import com.san.hospitalsystem.service.IUserService;
import com.san.hospitalsystem.utils.JWTUtil;
import com.san.hospitalsystem.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public ServerResponse<User> register(User user) {
    String password = MD5Util.MD5EncodeUtf8(user.getPassword());
    user.setPassword(password);
    System.out.println(user);
    int res = userMapper.insert(user);
    if (res <= 0) return ServerResponse.createByError("注册失败");

    user.setPassword(null);


    return ServerResponse.createBySuccess("注册成功", user);
  }

  @Override
  public ServerResponse<User> updateUser(User user) {
    return null;
  }

  @Override
  public ServerResponse<String> login(User user) {
    return null;
  }

  @Override
  public ServerResponse<Boolean> logout(User user) {
    return null;
  }

  @Override
  public ServerResponse<Boolean> validToken(String tokenId) {
    return null;
  }

  @Override
  public ServerResponse<String> updateToken(String tokenId) {
    return null;
  }
}
