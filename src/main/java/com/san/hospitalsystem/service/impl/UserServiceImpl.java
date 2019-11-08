package com.san.hospitalsystem.service.impl;

import com.san.hospitalsystem.Mapper.UserMapper;
import com.san.hospitalsystem.common.ServerResponse;
import com.san.hospitalsystem.entity.Token;
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
  public ServerResponse register(User user) {
    User u = userMapper.queryUserInfo(user);
    if (u != null) return ServerResponse.error("用户名已被他人使用");

    String password = MD5Util.MD5EncodeUtf8(user.getPassword());
    user.setPassword(password);
    int res = userMapper.insert(user);
    System.out.println(user + " -> " + res);
    if (res <= 0) return ServerResponse.error("注册失败");

    Token token = new Token();
    token.setTokenId(JWTUtil.create(user.getUsername()));
    return ServerResponse.success("注册成功", token);
  }


  @Override
  public ServerResponse<User> update(User user) {
    return null;
  }

  @Override
  public ServerResponse login(User user) {
    user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
    user = userMapper.queryUserInfo(user);
    if (user == null) return ServerResponse.error("用户名或密码错误");

    Token token = new Token();
    token.setTokenId(JWTUtil.create(user.getUsername()));
    return ServerResponse.success("登录成功", token);
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
