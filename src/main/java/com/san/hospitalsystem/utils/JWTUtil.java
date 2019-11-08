package com.san.hospitalsystem.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {
  private static final String CLAIM_KEY = "userName";
  private static final String SECRET = PropertyUtil.getProperty("jwt.secret");
  private static final long EXPIRE_TIME = Long.parseLong(PropertyUtil.getProperty("jwt.expired.time"));

  public static String create(String userName) {
    Date expiredDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

    String token = null;
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      token = JWT.create()
          .withClaim(CLAIM_KEY, userName)
          .withExpiresAt(expiredDate)
          .sign(algorithm);
    } catch (Exception  e) {
      e.printStackTrace();
    }

    return token;
  }

  public static boolean verify(String token, String userName) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim(CLAIM_KEY, userName)
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
      Claim claim = jwt.getClaim(CLAIM_KEY);
      return claim.asInt();
    } catch (Exception exception){
      return -1;
    }
  }
}
