package ua.artcode.ClassWork.Week_4.Thread;

/**
 * Created by serhii on 18.07.15.
 */
public class TestThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {
        Runnable runn = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //SimpleCreateAndRun.showThreadInfo(i);

                }
            }

        };
        Thread thread = new Thread(runn);
        System.out.println("After create");
        System.out.println(thread.getState());

        thread.start();
        System.out.println("After start");
        System.out.println(thread.getState());

        thread.sleep(10000);
        System.out.println("while sleep");
        System.out.println(thread.getState());

        thread.join();
        System.out.println("After join");
        System.out.println(thread.getState());
    }

}
