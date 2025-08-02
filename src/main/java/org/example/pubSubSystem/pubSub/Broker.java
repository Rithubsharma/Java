package org.example.pubSubSystem.pubSub;

import java.util.HashMap;
import java.util.Map;

public class Broker {
    Map<String, Map<String, ConusmerMetaData>> conusmers;
    Map<String, Topic> topics;
    private static Broker broker;

    public Broker () {
        conusmers = new HashMap<>();
        topics = new HashMap<>();
    }

    public static synchronized Broker getBroker() {
        if (broker == null) {
            broker = new Broker();
        }
        return broker;
    }

    public void createTopic(String topic) {
        topics.put(topic, new Topic(topic));
        conusmers.put(topic, new HashMap<>());
    }

    public void registerConsumer(String topic, String consumerId) {
        ConusmerMetaData conusmerMetaData = new ConusmerMetaData(consumerId);
        if (!conusmers.containsKey(topic)) {
            System.out.println("Topic " + topic + " does not exist");
        } else {
            conusmers.get(topic).put(consumerId, conusmerMetaData);
        }
    }

    public void sendMessage(String topic, String message) {
        if (!topics.containsKey(topic)) {
            System.out.println("Topic " + topic + " does not exist");
        } else {
            topics.get(topic).addMessage(message);
        }
    }

    public String receiveMessage(String topic, String consumerId) {
        if (!topics.containsKey(topic)) {
            System.out.println("Topic " + topic + " does not exist");
            return null;
        } else {
            if (!conusmers.get(topic).containsKey(consumerId)) {
                System.out.println("Topic " + topic + " does not exist");
            } else {
                ConusmerMetaData conusmerMetaData = conusmers.get(topic).get(consumerId);
                if (topics.get(topic).getCounter() < conusmerMetaData.getOffset()) {
                    System.out.println("Topic " + topic + " has no more messages");
                    return null;
                } else {
                    return topics.get(topic).getMessage(conusmerMetaData.getOffset());
                }
            }
        }
        System.out.println("Topic " + topic + " has no more messages");
        return null;
    }

    public void ack(String topic, String consumerId) {
        ConusmerMetaData conusmerMetaData = conusmers.get(topic).get(consumerId);
        conusmerMetaData.incrementOffset();
        conusmers.get(topic).put(consumerId, conusmerMetaData);
    }
}
