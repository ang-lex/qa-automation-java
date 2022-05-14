package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {
  public boolean isArgsValid(Message message){
    return message != null && message.getBody() != null;
  }
}
