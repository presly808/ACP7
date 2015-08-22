package week4.thread;


public class SimpleCreateAndRun {
    //Main thread

    public static void main(String[] args) {

        Thread mainthread = Thread.currentThread();
        mainthread.setName("Главный поток");
        MyOutPrintThread myThread = new MyOutPrintThread();
        myThread.setDaemon(true);
        myThread.start(); //starts separate thread

        MyOutPrintThread myThread2 = new MyOutPrintThread();
        myThread2.setDaemon(true);
        myThread2.start(); //starts separate thread
        for(int i = 0; i < 10; i++) {

            showThread(i);

        }System.out.println("Stop");



    }public static  void showThread(int i) {
        Thread curr =  Thread.currentThread();
        System.out.printf("id %s, name %s, priority %s, cout %d \n", curr.getId(),
                curr.getName(),
                curr.getPriority(), i);

    }
}


class MyOutPrintThread extends  Thread {

    @Override
    public void run() {

        Thread t = this;
        for(int i = 0; i< 100; i++) {
            SimpleCreateAndRun.showThread(i);

        }
    }
}