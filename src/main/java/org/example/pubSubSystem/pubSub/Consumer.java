package org.example.pubSubSystem.pubSub;

public class Consumer {
    private String topic;
    private String consumerId;
    private Broker broker;
    private Object lock;
    private boolean active;

    public Consumer(Object lock) {
        this.topic = "topic_1";
        this.consumerId = "consumer_1";
        this.broker = Broker.getBroker();
        this.lock = lock;
        this.active = false;
    }

    public void start() {
        synchronized (lock) {
            if (!active) {
                receiveMessage();
                active = true;
            }
        }
    }

    private void receiveMessage() {
        Thread consumerThread = new Thread(() -> {
            while (true) {
                String message = null;
                synchronized (lock) {
                    try {
                        while ((message = broker.receiveMessage(topic, consumerId)) == null) {
                            lock.wait();
                        }

                        System.out.println("Consumed message :: " + message);

                        broker.ack(topic, consumerId);
                    } catch (InterruptedException e) {
                        System.out.println("error thread interrupted");
                    }
                }
            }
        });
        consumerThread.start();
    }
}
