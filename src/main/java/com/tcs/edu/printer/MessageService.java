package com.tcs.edu.printer;

import com.tcs.edu.decorator.CutDecorator;
import com.tcs.edu.decorator.Severity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.tcs.edu.printer.Doubling.DISTINCT;
import static com.tcs.edu.printer.MessageOrder.ASC;
import static com.tcs.edu.decorator.SeverityDecorator.severityLevel;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.value;

/**
 *
 */
public class MessageService {
  static ArrayList<String> printedMessages = new ArrayList<>();

  public static void print(Severity level, String... messages) {
    if ((level != null) && (messages != null)) {
      for (String message : messages) {
        if (message != null) {
          printedMessages.add(message);
          ConsolePrinter.print(CutDecorator.cutter(decorate(message) + " " + severityLevel(level)));
        }
      }
    }
  }

  public static void print(Severity level, MessageOrder messageService, String... messages) {
    if (messageService == ASC) {
      print(level, messages);
    } else {
      for (int i = messages.length - 1; i >= 0; i--) {
        printedMessages.add(messages[i]);
        print(level, messages[i]);
      }
    }
  }


  public static void print(Severity level, MessageOrder messageService, Doubling doubling, String... messages) {
    if ((doubling == DISTINCT)) {
      for (String message : messages) {
        if ((message != null) && (!printedMessages.contains(message))) {
          print(level, messageService, message);
        }
      }
    } else {
      print(level, messageService, messages);
    }
  }
}
