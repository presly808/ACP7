package week4.day1;

/**
 * Created by Legion on 18.07.2015.
 */
public class SimpleCreatedAndRun {
    //Main Thread
    public static void main(String[] args) {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println("Main " + i);
        }

        MyOutPrintThread myOutPrintThread = new MyOutPrintThread();
        myOutPrintThread.start(); //start separate thread (parallet action)
    }
}


class MyOutPrintThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Thread " + i);
        }
    }
}