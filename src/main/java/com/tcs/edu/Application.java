package com.tcs.edu;

import static com.tcs.edu.printer.Doubling.DISTINCT;
import static com.tcs.edu.printer.Doubling.DOUBLES;
import static com.tcs.edu.printer.MessageOrder.ASC;
import static com.tcs.edu.printer.MessageOrder.DESC;
import static com.tcs.edu.decorator.Severity.getRandom;
import static com.tcs.edu.printer.MessageService.print;

class Application {
  public static void main(String[] args) {
    print(getRandom(), "Hello world!", "test1", "test2");
    print(getRandom(), ASC, "Hello world!1");
    print(null, ASC, "Hello world!2");
    print(getRandom(), DESC, "Hello world!3", null);
    print(getRandom(), ASC, "Hello world!4");
    print(getRandom(), DESC, "Hello world!5", "test1", "test2");
    print(getRandom(), DESC, "Hello world!6");
    print(getRandom(), ASC, null);
    print(getRandom(), ASC, "Hello world!7");
    print(getRandom(), DESC, DISTINCT, "Hello world!", "test13", "test2");
    print(getRandom(), ASC, DISTINCT, "Hello world!");
    print(getRandom(), ASC, DOUBLES, null);
    print(getRandom(), ASC, DOUBLES, "Hello world!10");
  }
}