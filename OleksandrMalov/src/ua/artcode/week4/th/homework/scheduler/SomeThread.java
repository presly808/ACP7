package ua.artcode.week4.th.homework.scheduler;

/**
 * Created by Олександр on 22.07.2015.
 */
public class SomeThread implements Runnable{

    private String name;
    private int count;
    private final long timeSleep;

    public SomeThread(String name, int count, long timeSleep) {
        this.name = name;
        this.count = count;
        this.timeSleep = timeSleep;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <this.count ; i++) {
            sum = sum + i;
        }
        System.out.println(name + " is going to sleep for " + timeSleep + " and has sum = " + sum);
        try{
            Thread.sleep(this.timeSleep);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
