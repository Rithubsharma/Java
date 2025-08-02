package org.example.pubSubSystem.pubSub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PubSubDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        Broker broker = Broker.getBroker();
        broker.createTopic("topic_1");
        broker.registerConsumer("topic_1", "consumer_1");

        consumer.start();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->  producer.send("Message number : " + finalI, "topic_1"));
            futures.add(future);
        }

        futures.forEach(CompletableFuture::join);

        synchronized (lock) {
            lock.wait();
        }
    }
}
