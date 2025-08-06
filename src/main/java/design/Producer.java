package design;

public class Producer {
    private Broker broker;
    private Object lock;

    public Producer(Object lock) {
        this.broker = Broker.getBroker();
        this.lock = lock;
    }

    public void send(boolean isSync, String messsage, String topic){
        broker.sendMessage(isSync, topic, messsage);
        synchronized (lock){
            lock.notifyAll();
        }
    }
}
