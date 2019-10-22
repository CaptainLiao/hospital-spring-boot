package com.san.hospitalsystem.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
  private Integer id;
  private Integer role;
  private String username;
  private String password;
  private String avatar;
  private Date updateTime;
  private Date createTime;
}
