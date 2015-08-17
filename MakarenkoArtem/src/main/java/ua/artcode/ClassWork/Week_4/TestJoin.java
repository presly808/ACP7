package ua.artcode.ClassWork.Week_4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by serhii on 18.07.15.
 */
public class TestJoin {


    // Main manager
    public static void main(String[] args) throws InterruptedException {

        // for collect all reports
        List<WorkerThread> workers = new LinkedList<WorkerThread>();

        // for manipulate threads
        List<Thread> threads = new LinkedList<Thread>();

        int threadSize = 5;
        for (int i = 0; i < threadSize; i++) {
            WorkerThread target = new WorkerThread(2000);
            workers.add(target);

            Thread th1 = new Thread(target);
            threads.add(th1);
            th1.start();
        }


        for (int i = 0; i < threadSize; i++) {
            Thread targetThread = threads.get(i);
            targetThread.join();
        }


        String res = "";
        for (WorkerThread worker : workers) {
            res += worker.getReport() + "\n";
        }

        System.out.println(res);


        System.out.println("Finish work");

    }
}


class WorkerThread implements Runnable {

    private StringBuilder report = new StringBuilder(Thread.currentThread().getName());

    private int count;

    public WorkerThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {

        for (int i = 0; i <= count; i++) {
            report.append("->").append(100 * i / count).append("%");
        }
    }

    public String getReport(){
        return report.toString();
    }
}


