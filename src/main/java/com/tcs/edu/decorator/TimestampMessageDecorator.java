package com.tcs.edu.decorator;

import java.time.Instant;

public class TimestampMessageDecorator {
  /**
   * Add current time for incoming string
   * @param message
   * @return Current Date&Time and message
   */
  public static String decorate(String message) {
    return Instant.now().toString() + " " + message;
  }
}
