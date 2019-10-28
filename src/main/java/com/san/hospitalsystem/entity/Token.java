package com.san.hospitalsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Token {
  private String tokenId;
  private Integer userId;
  private Integer status;
  private Date expiredTime;
}
