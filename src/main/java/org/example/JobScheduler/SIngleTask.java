package org.example.JobScheduler;

public class SIngleTask extends Task {

    public SIngleTask(long nextRunTime, Runnable action) {
        super(nextRunTime, action);
    }
}
