package org.example.linkedIn;

import java.sql.Timestamp;

public class Connections {
    private User user;
    private Timestamp connectionDate;

    public Connections(User user, Timestamp connectionDate) {
        this.user = user;
        this.connectionDate = connectionDate;
    }

    public User getUser() {
        return user;
    }

    public Timestamp getConnectionDate() {
        return connectionDate;
    }
}
