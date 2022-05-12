package com.tcs.edu.interfaces;

import com.tcs.edu.domain.Message;

public interface MessageDecorator {
  String decorate(Message message);
}
