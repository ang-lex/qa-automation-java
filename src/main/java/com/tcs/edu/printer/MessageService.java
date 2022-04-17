package com.tcs.edu.printer;

import com.tcs.edu.decorator.CutDecorator;
import com.tcs.edu.decorator.Severity;

import static com.tcs.edu.decorator.SeverityDecorator.severityLevel;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

/**
 *
 */
public class MessageService {
  public static void print(Severity level, String message) {
    ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
  }
}
