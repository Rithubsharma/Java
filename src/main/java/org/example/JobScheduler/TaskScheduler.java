package org.example.JobScheduler;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskScheduler {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    PriorityQueue<Task> priorityQueue = new PriorityQueue<>(Comparator.comparing(Task::getNextRunTime));
    final Object lock = new Object();

    public void addTask(Task task) {
        synchronized (lock) {
            priorityQueue.add(task);
            lock.notifyAll();
        }
    }

    public void executeTask() throws InterruptedException {
        while (true) {
            try {
                Task task;
                synchronized (lock) {
                    while (priorityQueue.isEmpty()) {
                        lock.wait();
                    }
                    task = priorityQueue.peek();
                    long delay = task.getNextRunTime() - System.currentTimeMillis();
                    if (delay > 0) {
                        lock.wait(delay);
                        continue;
                    }
                    priorityQueue.poll();
                }

                executorService.submit(() -> {
                    task.getAction().run();
                    task.setStatus("executed");
                });

                if (task instanceof ReoccuringTask reoccuringTask) {
                    reoccuringTask.setLastRunTime(System.currentTimeMillis());
                    long nextRunTime = System.currentTimeMillis() + reoccuringTask.getInterval();
                    reoccuringTask.setNextRunTime(nextRunTime);
                    addTask(reoccuringTask);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void join() throws InterruptedException {
        while (!priorityQueue.isEmpty()){
            lock.wait();
        }
        return;
    }
}
