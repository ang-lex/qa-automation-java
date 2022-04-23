package com.tcs.edu.decorator;

import java.util.Random;

public enum Severity {
  MAJOR,
  MINOR,
  REGULAR;

  public static Severity getRandom() {
    return values()[new Random().nextInt(values().length)];
  }
}
