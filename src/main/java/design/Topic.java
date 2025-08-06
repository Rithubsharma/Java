package design;

import java.util.HashMap;
import java.util.Map;

public class Topic {
    private String name;
    //index at which msg to be added
    private Integer counter;
    private Map<Integer,String> messages;

    public Topic(String name){
        this.name = name;
        this.counter = 0;
        this.messages = new HashMap<>();
    }

    public void addMessage(String message){
        messages.put(counter,message);
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    public String getMessage(int offset){
        return messages.get(offset);
    }

}
