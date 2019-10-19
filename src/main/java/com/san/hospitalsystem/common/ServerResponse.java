package com.san.hospitalsystem.common;

import java.io.Serializable;

/**
 * 后端返回给前端的数据结构
 * {
 *   code: int,
 *   message: String,
 *   data: T
 * }*/

public class ServerResponse<T> implements Serializable {
  private int code;
  private String message;
  private T data;

  ServerResponse(int code) {
    this.code = code;
  }
  ServerResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }
  ServerResponse(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  ServerResponse(int code, T data) {
    this.code = code;
    this.data = data;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  public T getData() {
    return data;
  }

  public static <T> ServerResponse createBySuccess() {

    return new ServerResponse(ResponseCode.SUCCESS.getCode());
  }

  public static <T> ServerResponse createBySuccessMessage(String message) {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), message);
  }

  public static <T> ServerResponse createBySuccess(T data) {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), data);
  }
  public static <T> ServerResponse createBySuccess(String msg, T data) {
    return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
  }
  public static <T> ServerResponse createByError() {
    return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
  }

  public static <T> ServerResponse createByError(String message) {
    return new ServerResponse<T>(ResponseCode.ERROR.getCode(), message);
  }

  @Override
  public String toString() {
    return "ServerResponse{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}

















