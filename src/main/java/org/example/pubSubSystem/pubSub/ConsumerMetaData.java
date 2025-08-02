package org.example.pubSubSystem.pubSub;

import java.util.concurrent.atomic.AtomicInteger;

public class ConsumerMetaData {
    private String consumerId;
    private AtomicInteger offset;

    public ConsumerMetaData(String consumerId) {
        this.consumerId = consumerId;
        this.offset = new AtomicInteger(0);
    }

    public int getOffset() {
        return offset.get();
    }

    public void incrementOffset() {
        this.offset.incrementAndGet();
    }
}
