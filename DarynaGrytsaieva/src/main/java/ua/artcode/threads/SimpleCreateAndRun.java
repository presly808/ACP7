package ua.artcode.threads;

/**
 * Created by Daryna on 18-Jul-15.
 */
public class SimpleCreateAndRun {

    //Main Thread
    public static void main(String[] args) {

        MyOutPrintThread myThread = new MyOutPrintThread();
        myThread.start(); //starts separate thread

        MyOutPrintThread myThread1 = new MyOutPrintThread();
        myThread1.start(); //starts separate thread

        Thread curr =  Thread.currentThread();
        for (int i = 0; i < 1000; i++) {
            System.out.println(("id %s, name %s count %d " + curr.getID()), curr.getName(), curr,getPriority());
        }



    }

}

class MyOutPrintThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //Thread.currentThread();
            //Thread t = this;
            System.out.println(("Thread " + i));
        }
    }

}
