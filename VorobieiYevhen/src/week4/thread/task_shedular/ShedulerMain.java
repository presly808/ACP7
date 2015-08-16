package week4.thread.task_shedular;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ShedulerMain {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ActionListener actionListener = new ShowCurrentTime();
                Timer timer = new Timer(1000, actionListener);
                timer.start();
            }
        }).start();
        Thread.currentThread().join();
    }
}
