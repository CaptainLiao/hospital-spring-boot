package com.san.hospitalsystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JWTUtil {
  private static final String SECRET = PropertyUtil.getProperty("jwt.secret");
  private static final long EXPIRE_TIME = Long.parseLong(PropertyUtil.getProperty("jwt.expired.time"));

  public static String create(String username) {
    Date expiredDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

    String token = null;
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      token = JWT.create()
          .withClaim("username", username)
          .withExpiresAt(expiredDate)
          .sign(algorithm);
    } catch (Exception  e) {
      e.printStackTrace();
    }

    return token;
  }

  public static boolean verify(String token, String username) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim("username", username)
          .build(); //Reusable verifier instance

      verifier.verify(token);

      return true;
    } catch (Exception  e) {
      return false;
    }
  }
}
