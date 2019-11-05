package com.san.hospitalsystem.common.exception;

import com.san.hospitalsystem.common.ResponseCode;
import com.san.hospitalsystem.common.ServerResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody // 返回 json
public class ControllerAdviceProcessor {

  public ServerResponse handleException(Exception ex) {
    int code = ResponseCode.UNSPECIFIED.getCode();
    String message = ResponseCode.UNSPECIFIED.getMessage();

    if (ex instanceof BusinessException) {
      BusinessException businessException = (BusinessException) ex;
      code = businessException.getCodeMessage().getCode();
      message = businessException.getMessage();
    }

    return ServerResponse.error(code, message);
  }

}
