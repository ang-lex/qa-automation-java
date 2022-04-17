package com.tcs.edu;

import static com.tcs.edu.decorator.Severity.getRandom;
import static com.tcs.edu.printer.MessageService.print;

class Application {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      print(getRandom(), "Hello world!");
    }
  }
}