package org.example.linkedIn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Profile profile;
    private List<Connections> connections;
    private List<Message> inbox;
    private List<Message> sentMessages;
    private List<Notifications> notifications;

    public User(String name, String email, String password){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        connections = new ArrayList<>();
        inbox = new ArrayList<>();
        sentMessages = new ArrayList<>();
        notifications = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Connections> getConnections() {
        return connections;
    }

    public void addToConnections(Connections connection) {
        connections.add(connection);
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void addToInbox(Message message) {
       inbox.add(message);
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void addToSentMessages(Message message) {
        sentMessages.add(message);
    }

    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void addToNotifications(Notifications notification) {
       notifications.add(notification);
    }
}
