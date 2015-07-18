package ua.artcode.week4.th;

/**
 * Created by Олександр on 18.07.2015.
 */
public class SimpleCreateAndRun {
    //Main Thread
    public static void main(String[] args) {

        MyOutPrintThread myThread = new MyOutPrintThread();
        myThread.start(); // start separate threads(parallel action)

        MyOutPrintThread myThread1 = new MyOutPrintThread();
        myThread1.start(); // start separate threads(parallel action)

        Thread curr = Thread.currentThread();
        for (int i = 0; i < 1000; i++) {
            System.out.printf("id %s, name %s, priority %s, count %d/n", curr.getId(), curr.getName(), curr.getPriority(), i);
        }

    }

}


class MyOutPrintThread extends Thread{

    public void run(){
        for (int i = 0; i < 1000; i++) {
            Thread t = this;
            System.out.println("Thread " + i);
        }

    }

}
