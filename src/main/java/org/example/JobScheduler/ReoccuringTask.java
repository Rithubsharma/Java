package org.example.JobScheduler;

public class ReoccuringTask extends Task{
    long interval;
    long lastRunTime = -1;

    public ReoccuringTask(long nextRunTime, Runnable action, long interval) {
        super(nextRunTime, action);
        this.interval = interval;
    }

    public long getLastRunTime() {
        return this.lastRunTime;
    }

    public long getInterval() {
        return this.interval;
    }

    public void setLastRunTime(long lastRunTime) {
        this.lastRunTime = lastRunTime;
    }
}
