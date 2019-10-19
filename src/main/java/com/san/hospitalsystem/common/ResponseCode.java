package com.san.hospitalsystem.common;

public enum ResponseCode {

  SUCCESS(0, "success"),
  ERROR(1, "error"),
  NEED_LOGIN(10, "need login"),
  ILLEGAL_ARGUMENT(2, "illegal argument");

  private final int code;
  private final String message;

  ResponseCode(int code, String desc) {
    this.code = code;
    this.message = desc;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
