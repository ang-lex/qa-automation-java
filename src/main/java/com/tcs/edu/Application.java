package com.tcs.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.LogException;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageRepository;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.interfaces.MessageServiceSaver;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.repository.MessageServiceCollection;

import java.util.Collection;
import java.util.UUID;

import static com.tcs.edu.enums.Doubling.DISTINCT;
import static com.tcs.edu.enums.Doubling.DOUBLES;
import static com.tcs.edu.enums.MessageOrder.ASC;
import static com.tcs.edu.enums.MessageOrder.DESC;
import static com.tcs.edu.enums.Severity.*;

class Application {
  public static void main(String[] args) {
    MessageServiceSaver messageServiceSaver = new MessageServiceCollection();
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

    UUID key1 = messageServiceSaver.save(message1);
    UUID key2 = messageServiceSaver.save(message2);
    UUID key3 = messageServiceSaver.save(message3);
    UUID key4 = messageServiceSaver.save(message4);
//    UUID key5 = messageServiceSaver.save(message5);
//    UUID key6 = messageServiceSaver.save(message6);

    final Collection<Message> messageCollection = messageServiceSaver.findAll();

    service.print(message1, message2, message3, new Message());
    service.print(DESC, DISTINCT, new Message(REGULAR, "Message3"));
    service.print(ASC, DISTINCT, new Message(REGULAR, "Messagesage3"));

    try {
      service.print(DESC, DOUBLES, message1, message1, message1, message2,message3,message4,message5);
    }
    catch (LogException e){
      testExceptionLog(e);
    }
    try {
service.print(DESC, DISTINCT, message5);
    }
    catch (LogException e){
      testExceptionLog(e);
    }

    try {
    service.print(DESC, DISTINCT, message6);
    }
    catch (LogException e) {
      testExceptionLog(e);
    }
    System.out.println(message1);
    System.out.println(message1.hashCode());
    System.out.println(message1.equals(message2));
    System.out.println(message1.equals(message4));

    System.out.println("\r\n\r\n Print one saved message:");
    service.print(messageServiceSaver.findByPrimaryKey(key1));

    System.out.println("\r\n\r\n Print all saved message:");
    for (Message currentMessage : messageCollection) {
      service.print(currentMessage);
    }

    System.out.println("\r\n\r\n Print messages with severity");
    for (Message currentMessage : messageServiceSaver.findBySeverity(Severity.MAJOR)) {
      service.print(currentMessage);
    }
  }

  private static void testExceptionLog(Exception e) {
    System.out.println(e.getMessage() + " -> " + e.getCause().getMessage());
  }
}