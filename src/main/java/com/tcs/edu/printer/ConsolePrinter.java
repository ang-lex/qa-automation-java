package com.tcs.edu.printer;

import com.tcs.edu.interfaces.Printer;

public class ConsolePrinter implements Printer {
  /**
   * Class name ConsolePrinter.
   * Prints a message and then terminate the line.
   *
   * @param message String type
   * @throws NullPointerException
   * @author Alex Ang
   */
  public void print(String message) {
    System.out.println(message);
  }
}
