package com.tcs.edu.repository;

import com.tcs.edu.domain.ValidatedService;
import com.tcs.edu.domain.LogException;
import com.tcs.edu.domain.Message;
import com.tcs.edu.enums.Severity;
import com.tcs.edu.interfaces.MessageRepository;
import com.tcs.edu.interfaces.MessageServiceSaver;

import java.util.Collection;
import java.util.UUID;

public class MessageServiceCollection extends ValidatedService implements MessageServiceSaver {
  private MessageRepository messageCollection = new HashMapMessageRepository();

  public UUID save(Message message) {
    try {
      super.isArgsValid(message);
    } catch (IllegalArgumentException e) {
      throw new LogException(e);
    }
    return messageCollection.create(message);
  }

  @Override
  public Message findByPrimaryKey(UUID key) {
    return messageCollection.findByPrimaryKey(key);
  }

  @Override
  public Collection<Message> findAll() {
    return messageCollection.findAll();
  }

  @Override
  public Collection<Message> findBySeverity(Severity severity) {
    return messageCollection.findBySeverity(severity);
  }

}
