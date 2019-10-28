package com.san.hospitalsystem.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class JWTUtilTest {


  @Test
  void create() {
    String token = JWTUtil.create(1);
    Assert.assertTrue(JWTUtil.verify(token, 1));
    Assert.assertEquals(JWTUtil.decode(token), 1);
  }

  @Test
  void verify() {
    String expiredToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzE2NDg4MDgsInVzZXJuYW1lIjoibGlhb2RheWUifQ.i-dhuqTkyhTH-d0I7yK4Qkys2JRtsylD46DaBlB5OKo";
    Assert.assertFalse(JWTUtil.verify(expiredToken, 1));
  }

  @Test
  void decode() {
  }
}