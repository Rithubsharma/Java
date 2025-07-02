package org.example.JobScheduler;

public class Task {
    long nextRunTime;
    Runnable action;
    String status = "new";

    public Task(long nextRunTime, Runnable action) {
        this.action = action;
        this.nextRunTime = nextRunTime;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Runnable getAction(){
        return this.action;
    }

    public long getNextRunTime(){
        return this.nextRunTime;
    }

    public void setNextRunTime(long nextRunTime) {
        this.nextRunTime = nextRunTime;
    }

}
