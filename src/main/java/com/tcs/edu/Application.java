package com.tcs.edu;

import static com.tcs.edu.decorator.MessageOrder.ASC;
import static com.tcs.edu.decorator.MessageOrder.DESC;
import static com.tcs.edu.decorator.Severity.getRandom;
import static com.tcs.edu.printer.MessageService.print;

class Application {
  public static void main(String[] args) {
    print(getRandom(), ASC,"Hello world!");
    print(null,ASC, "Hello world!");
    print(getRandom(),DESC, "Hello world!", null);
    print(getRandom(), ASC,"Hello world!");
    print(getRandom(), DESC,"Hello world!", "test1", "test2");
    print(getRandom(), DESC,"Hello world!");
    print(getRandom(), ASC,null);
    print(getRandom(), ASC,"Hello world!");
  }
}