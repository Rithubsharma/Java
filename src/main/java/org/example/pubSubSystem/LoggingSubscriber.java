package org.example.pubSubSystem;

public class LoggingSubscriber implements Subscriber{
    private final String name;

    public LoggingSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void consume(MessagePayload message) {
        System.out.println("[LOG] " + name + " received: " + message.getPayload());
    }
}
