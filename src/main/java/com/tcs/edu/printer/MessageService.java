package com.tcs.edu.printer;

import com.tcs.edu.decorator.CutDecorator;
import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;

import java.util.ArrayList;

import static com.tcs.edu.decorator.Doubling.DISTINCT;
import static com.tcs.edu.decorator.MessageOrder.ASC;
import static com.tcs.edu.decorator.SeverityDecorator.severityLevel;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.value;

/**
 *
 */
public class MessageService {
  static ArrayList<String> printedMessages = new ArrayList<String>();

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

  public static void print(Severity level, MessageOrder messageService, String... messages) {
    try {
      if (messageService == ASC) {
        for (String message : messages) {
          printedMessages.add(message);
          if (message != null) {
            ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
          }
        }
      } else {
        for (int i = messages.length - 1; i >= 0; i--) {
          printedMessages.add(messages[i]);
          if (messages[i] != null) {
            ConsolePrinter.print(CutDecorator.cutter(decorate(messages[i]) + " " + severityLevel(level)));
          }
        }
      }
    } catch (Exception e) {
      value--;
    }
  }

  public static void print(Severity level, MessageOrder messageService, Doubling doubling, String... messages) {
    if (doubling == DISTINCT) {
        try {
          if (messageService == ASC) {
            for (String message : messages) {
              if ((message != null)&&(!printedMessages.contains(message))) {
                ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
              }
              printedMessages.add(message);
            }
          } else {
            for (int i = messages.length - 1; i >= 0; i--) {
              if ((messages[i] != null)&&(!printedMessages.contains(messages[i]))) {
                ConsolePrinter.print(CutDecorator.cutter(decorate(messages[i]) + " " + severityLevel(level)));
              }
              printedMessages.add(messages[i]);
            }
          }
        } catch (Exception e) {
          value--;
        }
    }
  }
}
