package com.san.hospitalsystem.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5UtilTest {

  @Test
  void MD5EncodeUtf8() {
    String r1 = MD5Util.MD5EncodeUtf8("lfy0916");
    String r2 = MD5Util.MD5EncodeUtf8("lfy0916");
    System.out.println("lfy0916 经过 MD5 加密后的值为：" + r1);
    Assert.assertEquals(r1, r2);
  }
}