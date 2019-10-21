package com.san.hospitalsystem.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyUtilTest {

  @Test
  void getProperty() {
    String salt = "Fi4qA8e#&%KS.ch.od$!2da5ry^10_*,}?@";

    String res = PropertyUtil.getProperty("password.salt");

    Assert.assertEquals(res, salt);
  }
}