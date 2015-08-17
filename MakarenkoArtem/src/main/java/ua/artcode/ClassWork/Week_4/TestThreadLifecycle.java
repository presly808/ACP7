package ua.artcode.ClassWork.Week_4;

public class TestThreadLifecycle {

    public static void main(String[] args) throws InterruptedException {
        Thread main = Thread.currentThread();
        Runnable runn = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000000; i++) {
                    Math.sin(Math.sqrt(Math.cos(i)));
                    //System.out.println("Main status " + main.getState());
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
        thread.sleep(1000); //native, sleep via system
        System.out.println("while sleep");
        System.out.println(thread.getState());

        thread.join();
        System.out.println("After join");
        System.out.println(thread.getState());



    }
}
