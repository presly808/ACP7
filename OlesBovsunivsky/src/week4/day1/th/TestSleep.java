package week4.day1.th;

/**
 * Created by serhii on 18.07.15.
 */
public class TestSleep {


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyShowThread());
            thread.start();
        }
    }
}

class MyShowThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SimpleCreateAndRun.showThreadInfo(i);
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
