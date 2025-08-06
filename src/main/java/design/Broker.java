package design;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    Map<String, Map<String, ConsumerMeta>> consumers;
    Map<String,Topic> topics;
    private static Broker broker;

    private Consumer syncConsumer;


    private Broker(){
        consumers = new HashMap<>();
        topics= new HashMap<>();
    }

    public static synchronized Broker getBroker(){
        if(broker==null){
            broker = new Broker();
        }
        return broker;
    }

    public void sendMessage(boolean isSync, String topic, String message){
        if (isSync) {
            syncConsumer.receiveMessages(isSync,message);
        } else{
            if(topics.containsKey(topic)){
                topics.get(topic).addMessage(message);
            } else{
                // topic is not present
            }
        }
    }

    public String receiveMessage(String topic, String consumerId){
        if(topics.containsKey(topic)) {

        } else{
            if(!consumers.get(topic).containsKey(consumerId)){

            } else{
                ConsumerMeta consumerMeta = consumers.get(topic).get(consumerId);

                return topics.get(topic).getMessage(consumerMeta.getOffset());
            }
            // topic is not present
        }

        return null;
    }
}
