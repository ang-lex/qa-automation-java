package com.tcs.edu.printer;

import com.tcs.edu.decorator.CutDecorator;
import com.tcs.edu.decorator.Severity;

import static com.tcs.edu.decorator.SeverityDecorator.severityLevel;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.value;

/**
 *
 */
public class MessageService {
  public static void print(Severity level, String... messages) {
    try {
      for (String message : messages) {
        if (message != null) {
          ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
        }
      }
    } catch (Exception e) {
      value--;
    }
  }
}
