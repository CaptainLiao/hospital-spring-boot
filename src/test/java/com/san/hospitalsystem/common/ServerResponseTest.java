package com.san.hospitalsystem.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ServerResponseTest {

  @Test
  void createBySuccess() {
    ServerResponse serverResponse = ServerResponse.createBySuccess();
    System.out.println(serverResponse.toString());
  }

  @Test
  void createBySuccessMessage() {
  }

  @Test
  void createBySuccess1() {
  }

  @Test
  void createBySuccess2() {
  }

  @Test
  void createByError() {
  }
}