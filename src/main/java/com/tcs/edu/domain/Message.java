package com.tcs.edu.domain;

import com.tcs.edu.enums.Severity;

import static com.tcs.edu.enums.Severity.MINOR;

public class Message {
  private Severity severity;
  private String body;

  public Message(Severity severity, String body) {
    this.severity = severity;
    this.body = body;
  }

  public Message(String body) {
    new Message(MINOR, body);
  }

  public Message() {
    new Message(MINOR, "default test");
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
}
