package ua.artcode.ClassWork.Week_4;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by serhii on 19.07.15.
 */
public class ConcurrentAtomicTest {




    public static void main(String[] args) throws InterruptedException {

        AtomicLong atomicLong = new AtomicLong(2300);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    atomicLong.decrementAndGet();
                }
            }
        });

        t2.start();

        t1.join();
        t2.join();

        System.out.println(atomicLong.get());



    }
}
