package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.MessageDecorator;

import java.time.Instant;


/**
 * Class for adding Date&Time for incoming string
 */
public class TimestampMessageDecorator implements MessageDecorator {
  public static int value;

  /**
   * Add current time for incoming string
   *
   * @param message
   * @return Current Date&Time and message
   */
  public String decorate(Message message) {
    value++;
    return String.format("%d, %s, %s", value, Instant.now(), message.getBody());
  }
}
