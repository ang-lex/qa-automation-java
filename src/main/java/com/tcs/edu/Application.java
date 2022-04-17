package com.tcs.edu;

import static com.tcs.edu.decorator.Severity.getRandom;
import static com.tcs.edu.printer.MessageService.print;

class Application {
  public static void main(String[] args) {
    print(getRandom(), "Hello world!");
    print(getRandom(), "Hello world!");
    print(getRandom(), "Hello world!", "test");
    print(getRandom(), "Hello world!");
    print(getRandom(), "Hello world!", "test1", "test2");
    print(getRandom(), "Hello world!");
    print(getRandom(), "Hello world!");
    print(getRandom(), "Hello world!");
  }
}