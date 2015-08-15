package ua.artcode.week4.th.homework.scheduler;

import ua.artcode.week4.th.homework.scheduler.SomeThread;

import java.util.concurrent.*;


public class Scheduler {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        Runnable task = new SomeThread("Thread");
        Runnable task2 = new SomeThread("Thread2");
        Runnable task3 = new SomeThread("Thread3");
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(task2, 0, 1, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(task3, 0, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        executor.shutdown();







    }
}
