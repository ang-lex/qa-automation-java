package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.TimestampMessageDecorator.value;

/**
 * Class for separating messages by page size
 */
public class CutDecorator {
  public static final int PAGE_SIZE = 2;

  public static String cutter(String cutter) {
    String templateCut = "%s";
    if ((value) % PAGE_SIZE == 0) {
      templateCut += "\n ______";
    }
    return String.format(templateCut, cutter);
  }
}
