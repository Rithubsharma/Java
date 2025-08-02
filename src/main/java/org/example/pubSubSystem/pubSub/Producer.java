package org.example.pubSubSystem.pubSub;

public class Producer {
    private Broker broker;
    private Object lock;

    public Producer(Object lock) {
        this.broker = Broker.getBroker();
        this.lock = lock;
    }

    void send(String msg, String topic) {
        broker.sendMessage(topic, msg);
        System.out.println("Sent message :: " + msg);
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
