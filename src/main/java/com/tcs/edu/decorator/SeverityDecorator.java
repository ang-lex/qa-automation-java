package com.tcs.edu.decorator;

import com.tcs.edu.enums.Severity;

/**
 * Class for return severity level  message
 */
public class SeverityDecorator {
  public static String severityLevel(Severity severity) {
    String severityString = null;
    switch (severity) {
      case MINOR:
        severityString = "()";
        break;
      case REGULAR:
        severityString = "(!)";
        break;
      case MAJOR:
        severityString = "(!!)";
        break;
    }
    return severityString;
  }
}
