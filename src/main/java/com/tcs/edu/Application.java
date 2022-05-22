package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.enums.Doubling.DISTINCT;
import static com.tcs.edu.enums.Doubling.DOUBLES;
import static com.tcs.edu.enums.MessageOrder.ASC;
import static com.tcs.edu.enums.MessageOrder.DESC;
import static com.tcs.edu.enums.Severity.*;

class Application {
  public static void main(String[] args) {
    MessageService service = new com.tcs.edu.decorator.OrderedDistinctedMessageService(
        new ConsolePrinter(),
        new TimestampMessageDecorator()
    );
    Message message1 = new Message(MAJOR,"Major message");
    Message message2 = new Message(MINOR,"Major message");
    Message message3 = new Message(REGULAR,"Major message");
    Message message4 = new Message("message");
    Message message5 = new Message(null,"body");
    Message message6 = new Message(null);
    service.print(message1, message2, message3, new Message());
    service.print(DESC, DISTINCT, new Message(REGULAR, "Message3"));
    service.print(ASC, DISTINCT, new Message(REGULAR, "Messagesage3"));
    service.print(DESC, DOUBLES, message1, message1, message1, message2,message3,message4,message5);
    service.print(DESC, DISTINCT, message5);
    service.print(DESC, DISTINCT, message6);
    System.out.println(message1);
    System.out.println(message1.hashCode());
    System.out.println(message1.equals(message2));
    System.out.println(message1.equals(message4));
  }
}