package com.san.hospitalsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private int id;
  private int role;
  private String username;
  private String password;
  private String avatar;
  private Date updateTime;
  private Date createTime;
}
