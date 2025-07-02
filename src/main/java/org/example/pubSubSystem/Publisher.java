package org.example.pubSubSystem;

public class Publisher {
    private final String id;
    private final Broker broker;

    public Publisher(String id, Broker broker) {
        this.id = id;
        this.broker = broker;
    }

    public void publish(String topic, String payload) {
        broker.publish(topic, new MessagePayload(payload));
    }

    public String getId() {
        return id;
    }
}
