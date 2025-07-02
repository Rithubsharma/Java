package org.example.pubSubSystem;

public class PrintSubscriber implements Subscriber{
    private final String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void consume(MessagePayload message) {
        System.out.println("Subscriber " + name + " received message: " + message.getPayload());
    }
}
