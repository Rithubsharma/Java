package org.example.pubSubSystem;

public class MessagePayload {
    private String payload;

    public MessagePayload(String payload){
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
