package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Doubling;
import com.tcs.edu.enums.MessageOrder;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageDecorator;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.interfaces.Printer;

import java.util.ArrayList;
import java.util.List;

import static com.tcs.edu.decorator.CutDecorator.cutter;
import static com.tcs.edu.enums.Doubling.DISTINCT;
import static com.tcs.edu.enums.MessageOrder.ASC;

/**
 *
 */
public class OrderedDistinctedMessageService extends ValidatedService implements MessageService {
  private Printer printer;
  private MessageDecorator messageDecorator;

  public OrderedDistinctedMessageService(Printer printer, MessageDecorator messageDecorator) {
    this.printer = printer;
    this.messageDecorator = messageDecorator;
  }

  public void print(Message... messages) {
    for (Message message : messages) {
      if (super.isArgsValid(message)) {
        printer.print(cutter(messageDecorator.decorate(message)));
      }
    }
  }

  public void print(MessageOrder order, Message... messages) {
    if (order == ASC) {
      print(messages);
    } else {
      for (int i = messages.length - 1; i >= 0; i--) {
        print(messages[i]);
      }
    }
  }


  public void print(MessageOrder order, Doubling doubling, Message... messages) {
    List<String> messagesList = new ArrayList<>();
    for (Message message : messages) {
      messagesList.add(message.getBody());
    }

    if ((doubling == DISTINCT)) {
      for (Message message : messages) {
        if (!messagesList.contains(message)) {
          print(order, message);
        }
      }
    } else {
      print(order, messages);
    }
  }
}
