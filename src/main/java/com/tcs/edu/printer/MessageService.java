package com.tcs.edu.printer;

import com.tcs.edu.decorator.CutDecorator;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;

import static com.tcs.edu.decorator.MessageOrder.ASC;
import static com.tcs.edu.decorator.SeverityDecorator.severityLevel;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.value;

/**
 *
 */
public class MessageService {
  public static void print(Severity level, MessageOrder messageService, String... messages) {
    try {
      if (messageService == ASC) {
        for (String message : messages) {
          if (message != null) {
            ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
          }
        }
      } else {
        for (int i = messages.length-1; i >= 0; i--) {
          if (messages[i] != null) {
            ConsolePrinter.print(CutDecorator.cutter(decorate(messages[i]) + " " + severityLevel(level)));
          }
        }
      }
    } catch (Exception e) {
      value--;
    }
  }
}
