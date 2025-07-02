package org.example.pubSubSystem;

public interface Subscriber {
    void consume(MessagePayload message);
}
