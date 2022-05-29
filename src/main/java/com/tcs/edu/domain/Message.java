package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;

import java.util.Objects;
import java.util.UUID;

import static com.tcs.edu.enums.Severity.MINOR;

public class Message {
  private UUID id;
  private Severity severity;
  private String body;

  public Message(Severity severity, String body) {
    this.id=UUID.randomUUID();
    this.severity = severity;
    this.body = body;
  }

  public Message(String body) {
    this(MINOR, body);
  }

  public Message() {
    this(MINOR, "default test");
  }

  public Severity getSeverity() {
    return severity;
  }

  public Message setSeverity(Severity severity) {
    this.severity = severity;
    return this;
  }

  public String getBody() {
    return body;
  }

  public Message setBody(String body) {
    this.body = body;
    return this;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public boolean equals(Object message) {
    if (message == null || this.getClass() != message.getClass()) return false;
    return severity == ((Message) message).severity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(severity, body);
  }

  @Override
  public String toString() {
    return "Message {severity : " + severity + " ; body : " + body + "}";
  }
}
