package org.example.linkedIn;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedInService {
    private static LinkedInService linkedInService;
    private Map<String,User> users;
    private Map<String, JobPosting> jobPostings;
    private Map<String, List<Notifications>> notifications;
    private LinkedInService(){
        users = new ConcurrentHashMap<>();
        jobPostings = new ConcurrentHashMap<>();
        notifications = new ConcurrentHashMap<>();
    }

    public static synchronized LinkedInService getInstance(){
        if(linkedInService == null){
            linkedInService = new LinkedInService();
        }
        return linkedInService;
    }

    public User registerUser(String name, String email, String password){
        User user = new User(name,email,password);
        users.put(user.getId(), user);
        return user;
    }

    public Boolean loginUser(String email, String password){
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void sendConnectionRequest(User sender, User receiver){
        receiver.getConnections().add(new Connections(sender,new Timestamp(System.currentTimeMillis())));
        sendNotification(receiver,NotificationType.CONNECTION_REQUEST,"New connection request from " + sender.getName());
    }

    public void acceptConnectionRequest(User user, User connectionUser) {
        for (Connections connection : user.getConnections()) {
            if (connection.getUser().equals(connectionUser)) {
                user.getConnections().add(new Connections(connectionUser, new Timestamp(System.currentTimeMillis())));
                connectionUser.getConnections().add(new Connections(user, new Timestamp(System.currentTimeMillis())));
                return;
            }
        }
        throw new BadRequestException("No pending connection request from this user.");
    }

    public List<User> searchUsers(String keyword) {
        List<User> results = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getName().contains(keyword)) {
                results.add(user);
            }
        }
        return results;
    }

    public JobPosting postJobListing(String title, String company, String description, String location) {
        JobPosting jobPosting = new JobPosting(title, company, description, location);
        jobPostings.put(jobPosting.getId(), jobPosting);
        return jobPosting;
    }

    public List<JobPosting> searchJobPostings(String keyword) {
        List<JobPosting> results = new ArrayList<>();
        for (JobPosting jobPosting : jobPostings.values()) {
            if (jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
                results.add(jobPosting);
            }
        }
        return results;
    }

    public void sendMessage(User sender, User receiver, String content) {
        Message message = new Message(sender, receiver, content);
        receiver.addToInbox(message);
        sender.addToSentMessages(message);
        sendNotification(receiver, NotificationType.MESSAGE, "New message from " + sender.getName());
    }


    public List<Notifications> getAllNotification(String userId){
        User user = users.get(userId);
        return user.getNotifications();
    }

    private void sendNotification(User receiver, NotificationType notificationType, String s) {
        Notifications notification = new Notifications(receiver,notificationType,s);
        receiver.getNotifications().add(notification);
    }
}
