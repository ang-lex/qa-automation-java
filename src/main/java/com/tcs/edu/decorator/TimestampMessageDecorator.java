package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Class for adding Date&Time for incoming string
 */
public class TimestampMessageDecorator {
  private static int value;
  public static final int PAGE_SIZE = 2;

  /**
   * Add current time for incoming string
   *
   * @param message
   * @return Current Date&Time and message
   */
  public static String decorate(String message) {
    if ((value + 1) %PAGE_SIZE == 0)
      message = message + "\n----------";
    final var decoratedMessage = String.format("%d %s %s", value++, Instant.now().toString(), message);
    return decoratedMessage;
  }
}
