package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;
import com.tcs.edu.interfaces.MessageRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class HashMapMessageRepository implements MessageRepository {
  private Map<UUID,Message> messages= new HashMap<>();

  @Override
  public UUID create(Message message) {
    messages.put(message.getId(),message);
    return message.getId();
  }

  @Override
  public Message findByPrimaryKey(UUID key) {
    return messages.get(key);
  }
}
