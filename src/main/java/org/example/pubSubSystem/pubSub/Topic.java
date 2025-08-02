package org.example.pubSubSystem.pubSub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Topic {
    private String name;
    private AtomicInteger counter;
    Map<Integer, String> messages;

    public Topic (String name) {
        this.name = name;
        this.counter = new AtomicInteger(0);
        this.messages = new ConcurrentHashMap<>();
    }

    public synchronized void addMessage(String message) {
        messages.put(counter.get(), message);
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public String getMessage(int offset) {
        return messages.get(offset);
    }
}
