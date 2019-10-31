package com.san.hospitalsystem.common.exception;

import com.san.hospitalsystem.common.ICodeMessage;
import com.san.hospitalsystem.common.ResponseCode;

public class BusinessException extends RuntimeException {

  private ICodeMessage codeMessage;

  public BusinessException() {
    super(ResponseCode.UNSPECIFIED.getMessage());
    this.codeMessage = ResponseCode.UNSPECIFIED;
  }

  public BusinessException(ICodeMessage codeMessage) {
    super(codeMessage.getMessage());
    this.codeMessage = codeMessage;
  }

  public BusinessException(ICodeMessage codeMessage, Throwable error) {
    super(codeMessage.getMessage(), error);
    this.codeMessage = codeMessage;
  }

  public ICodeMessage getCodeMessage() {
    return codeMessage;
  }
}
