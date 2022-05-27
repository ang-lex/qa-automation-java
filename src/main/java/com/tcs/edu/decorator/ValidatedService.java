package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

public abstract class ValidatedService {
  public void isArgsValid(Message message) {
    if (message == null) throw new IllegalArgumentException("Message is null");
    if (message.getSeverity() == null) throw new IllegalArgumentException("Severity is null");
    if (message.getBody() == null) throw new IllegalArgumentException("Body is null");
  }
}
