package com.san.hospitalsystem.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// Digital Signature Algorithm
public class DSA {
  public static String SHA1(String str) {
    char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    try {
      MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
      mdTemp.update(str.getBytes(StandardCharsets.UTF_8));
      byte[] md = mdTemp.digest();
      int j = md.length;
      char buf[] = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        byte byte0 = md[i];
        buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
        buf[k++] = hexDigits[byte0 & 0xf];
      }
      return new String(buf);
    } catch (Exception e) {
      return null;
    }
  }
}
