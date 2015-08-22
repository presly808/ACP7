package ua.artcode.ClassWork.Week_4;

/**
 * Created by serhii on 18.07.15.
 */
public class SimpleCreateAndRun {

    // MAIN THREAD
    public static void main(String[] args) {

        MyOutPrintThread myThread = new MyOutPrintThread();
        myThread.start(); // starts separate thread (parallel action)

        MyOutPrintThread myThread1 = new MyOutPrintThread();
        myThread1.start();


        for (int i = 0; i < 1000; i++) {
           showThreadInfo(i);
        }


    }

    public static void showThreadInfo(int i){
        Thread curr = Thread.currentThread();
        System.out.printf("id %s,name %s, priority %s ,count %d\n",
                curr.getId(),
                curr.getName(),
                curr.getPriority(),i);
    }


}


class MyOutPrintThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SimpleCreateAndRun.showThreadInfo(i);
        }
    }
}
