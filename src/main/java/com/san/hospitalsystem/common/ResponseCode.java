package com.san.hospitalsystem.common;

public enum ResponseCode implements ICodeMessage {

  SUCCESS(0, "success"),
  ERROR(1, "error"),
  NEED_LOGIN(10, "need login"),
  ILLEGAL_ARGUMENT(2, "illegal argument"),

  // 未指定的异常
  UNSPECIFIED(500, "服务器内部错误，请稍后再试"),
  NO_SERVICE(404, "网络异常, 服务器熔断");

  private final int code;
  private final String message;

  ResponseCode(int code, String desc) {
    this.code = code;
    this.message = desc;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
