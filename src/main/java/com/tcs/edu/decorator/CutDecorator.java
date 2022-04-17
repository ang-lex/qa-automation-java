package com.tcs.edu.decorator;

/**
 * Class for separating messages by page size
 */
public class CutDecorator {
  public static final int PAGE_SIZE = 2;
  public static int value;

  public static String cutter(String cutter) {
    String templateCut = "%s";
    if ((value + 1) % PAGE_SIZE == 0) {
      templateCut += "\n ______";
    }
    value++;
    return String.format(templateCut, cutter);
  }
}
