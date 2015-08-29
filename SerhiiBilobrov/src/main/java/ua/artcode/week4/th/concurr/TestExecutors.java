package ua.artcode.week4.th.concurr;

import ua.artcode.ds.hash.Main;

import java.util.concurrent.*;

public class TestExecutors {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    Math.acos(i);
                }
            }
        });

        System.out.println(future.isDone());

        Future<String> callableFuture = executorService.submit(new TaskWithRes());
        try {
            String res = callableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class TaskWithRes implements Callable<String> {

    @Override
    public String call() throws Exception {
        String res = "";
        for (int i = 0; i < 1000; i++) {
            res += Math.acos(i) + ",";
        }
        return res;
    }
}
