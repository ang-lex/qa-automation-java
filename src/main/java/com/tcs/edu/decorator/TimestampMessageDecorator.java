package com.tcs.edu.decorator;

import java.time.Instant;

import static com.tcs.edu.decorator.CutDecorator.value;

/**
 * Class for adding Date&Time for incoming string
 */
public class TimestampMessageDecorator {

  /**
   * Add current time for incoming string
   *
   * @param message
   * @return Current Date&Time and message
   */
  public static String decorate(String message) {
    return String.format("%d, %s, %s", value, Instant.now(), message);
  }
}
