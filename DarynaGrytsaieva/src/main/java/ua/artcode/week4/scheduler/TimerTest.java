package ua.artcode.week4.scheduler;

import java.util.Scanner;

/**
 * Created by Daryna on 21-Jul-15.
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start(1000, new Action() {
            @Override
            public void execute() {
                System.out.println("f*");
            }
        });

        Scanner scan = new Scanner(System.in);
        if(scan.nextLine().equals(".")){
            timer.stop();
        }

    }
}
