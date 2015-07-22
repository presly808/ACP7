package ua.artcode.week4.th.homework.scheduler;

import ua.artcode.week4.th.homework.scheduler.SomeThread;

import java.util.concurrent.*;

/**
 * Created by Олександр on 22.07.2015.
 */
public class SchedulerRun {

    private static Future taskTwo = null;
    private static Future taskThree = null;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = new SomeThread("Thread", 5, 1000);
        Future task1 = executor.submit(task);

            if ((taskTwo == null) || (taskTwo.isDone()) || (taskTwo.isCancelled()))
                taskTwo = executor.submit(new SomeThread("Thread2", 10, 200));

            if ((taskThree == null) || (taskThree.isDone()) || (taskThree.isCancelled()))
                taskThree = executor.submit(new SomeThread("Thread3", 8, 20));

            if(task1.get() == null)
                System.out.println("TaskOne terminated");
            else
                task1.cancel(true);

            if(taskTwo.get() == null)
                System.out.println("TaskTwo terminated");
            else
                taskTwo.cancel(true);

            if(taskThree.get() == null)
                System.out.println("TaskTHree terminated");
            else
                taskThree.cancel(true);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);






    }
}
