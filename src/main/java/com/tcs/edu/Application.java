package com.tcs.edu;

import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

class Application {
  public static void main(String[] args) {
    for (int i=0;i<10;i++) {
      ConsolePrinter.print(decorate("Hello world!"));
    }
  }
}