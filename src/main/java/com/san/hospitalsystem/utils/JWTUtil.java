package com.san.hospitalsystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {
  private static final String CLAIME_KEY = "userId";
  private static final String SECRET = PropertyUtil.getProperty("jwt.secret");
  private static final long EXPIRE_TIME = Long.parseLong(PropertyUtil.getProperty("jwt.expired.time"));

  public static String create(int userId) {
    Date expiredDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

    String token = null;
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      token = JWT.create()
          .withClaim(CLAIME_KEY, userId)
          .withExpiresAt(expiredDate)
          .sign(algorithm);
    } catch (Exception  e) {
      e.printStackTrace();
    }

    return token;
  }

  public static boolean verify(String token, int userId) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim(CLAIME_KEY, userId)
          .build(); //Reusable verifier instance

      verifier.verify(token);

      return true;
    } catch (Exception  e) {
      return false;
    }
  }

  public static int decode(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      Claim claim = jwt.getClaim(CLAIME_KEY);
      return claim.asInt();
    } catch (Exception exception){
      return -1;
    }
  }
}
