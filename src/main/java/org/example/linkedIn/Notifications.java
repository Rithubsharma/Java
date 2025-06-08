package org.example.linkedIn;

import java.util.Date;
import java.util.UUID;

public class Notifications {
    private String id;
    private User user;
    private NotificationType type;
    private String content;
    private Date timestamp;

    public Notifications(User user, NotificationType type, String content) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.type = type;
        this.content = content;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public NotificationType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
