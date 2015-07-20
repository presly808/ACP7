package ua.artcode.week4;

/**
 * Created by pikolo on 18.07.15.
 */
public class SimpleCreateAndRun {

    // MAIN is already THREAD
    public static void main(String[] args) {

        MyOutThread myThread = new MyOutThread();
        myThread.start(); // starts separate thread (parallel action)

        MyOutThread myThread1 = new MyOutThread();
        myThread.start(); // starts separate thread (parallel action)

        Thread curr = Thread.currentThread();

        for (int i = 0; i < 1000; i++) {
            System.out.printf("ID %s, name %s, priority %s, count %d ",
                    curr.getId(),
                    curr.getName(),
                    curr.getPriority(), i);
        }


    }

}


class MyOutThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread t = this;
            System.out.println("Thread " + i);
        }
    }

}
