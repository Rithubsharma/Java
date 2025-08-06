package design;

public class Consumer {
    private String topic;
    private String consumerId;
    private Broker broker;
    private Object lock;

    public Consumer(String topic, String consumerId, Object lock) {
        this.topic = topic;
        this.consumerId = consumerId;
        this.broker = Broker.getBroker();
        this.lock = lock;
    }

    public void receiveMessages(boolean isSync, String message){
        Thread consumerThread = new Thread(() ->{
            if(isSync){
                System.out.println("Consumed Sync message ::" + message);
            } else{
                while(true){
                    String asyncMessage = null;
                    synchronized (lock){
                        try{
                            while((asyncMessage = broker.receiveMessage(topic,consumerId))== null){
                                lock.wait();
                            }

                            System.out.println("Consumed message ::" + asyncMessage);
                        } catch(InterruptedException exception){
                            //

                        }

                    }
                }
            }

        });

        consumerThread.start();

    }
}
