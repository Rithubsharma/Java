package org.example.hotelManagementSystem;

public class Guest {
    private final String id;
    private final String name;
    private final String email;
    private final String contact;

    public Guest(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }
}
