package com.san.hospitalsystem.Mapper;

import com.san.hospitalsystem.entity.User;

public interface UserMapper {
  int insert(User user);
  Integer queryUserName(String username);
  User getUserInfo(int userId);
}
