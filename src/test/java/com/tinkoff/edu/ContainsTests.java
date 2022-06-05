package com.tinkoff.edu;

import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.MessageService;
import com.tcs.edu.printer.ConsolePrinter;
import org.junit.jupiter.api.Test;

import static com.tcs.edu.enums.Severity.MAJOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainsTests {
  MessageService service = new com.tcs.edu.decorator.OrderedDistinctedMessageService(
      new ConsolePrinter(),
      new TimestampMessageDecorator()
  );

  @Test
  public void shouldSuccessAddMessageObject(){
    Message message = new Message(MAJOR,"Major message");
    assertEquals("Message {severity : MAJOR ; body : Major message}",message.toString());
  }

  @Test
  public void shouldSuccessAddDefaultMessageObject(){
    Message message = new Message();
    assertThat(message).toString().equals("Message {severity : MINOR ; body : default test}");
  }
}
