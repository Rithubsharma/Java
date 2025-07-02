package org.example.pubSubSystem;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    private final String name;
    private final Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void broadcast(MessagePayload message) {
        for (Subscriber subscriber : subscribers) {
            Dispatcher.dispatch(subscriber, message);
        }
    }
}
