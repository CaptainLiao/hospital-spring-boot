package com.san.hospitalsystem.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Token {
  private String tokenId;
  private int userId;
  private int status;
  private Date expiredTime;
}
