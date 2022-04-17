package com.tcs.edu.decorator;

public enum Severity {
  MAJOR,
  MINOR,
  REGULAR;

  public static Severity getRandom() {
    return values()[(int) (Math.random() * values().length)];
  }
}
