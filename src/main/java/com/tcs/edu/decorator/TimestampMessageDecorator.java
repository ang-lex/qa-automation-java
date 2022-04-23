package com.tcs.edu.decorator;

import java.time.Instant;


/**
 * Class for adding Date&Time for incoming string
 */
public class TimestampMessageDecorator {
  public static int value;

  /**
   * Add current time for incoming string
   *
   * @param message
   * @return Current Date&Time and message
   */
  public static String decorate(String message) {
    value++;
    return String.format("%d, %s, %s", value, Instant.now(), message);
  }
}
