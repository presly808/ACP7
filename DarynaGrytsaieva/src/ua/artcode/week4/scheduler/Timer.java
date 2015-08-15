package ua.artcode.week4.scheduler;

/**
 * Created by Daryna on 21-Jul-15.
 */
public class Timer {

    private Thread timerThread;

    public void start(long period, Action action) {

        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                long currentTime;
                while (!timerThread.isInterrupted()) {
                    currentTime = System.currentTimeMillis();
                    if ((currentTime - startTime) >= period) {
                        action.execute();
                        startTime = currentTime;
                    }


                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Timer was stopped");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        timerThread.start();


    }

    public void stop() {
        timerThread.interrupt();
    }
}
