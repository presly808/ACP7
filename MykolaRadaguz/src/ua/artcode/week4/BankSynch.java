package ua.artcode.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by pikolo on 19.07.15.
 */
public class BankSynch {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        BankAccount bankAccount = new BankAccount(0);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ProducerThread(bankAccount));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }


        System.out.println("Money putted");
        System.out.println(bankAccount.getCurrent());

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new TakerThread(bankAccount));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("Money after withdrawals");
        System.out.println(bankAccount.getCurrent());
    }

}



class TakerThread implements Runnable {

    private static final int COUNT = 10000;
    private BankAccount account;

    public TakerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i <COUNT; i++) {
            account.takeMoney(200);
        }

    }

}

class ProducerThread implements Runnable {

    private static final int COUNT = 10000;
    private BankAccount account;

    public ProducerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            account.putMoney(100);
        }
    }
}

class BankAccount {

    private int money;
    private final Object monitor = new Object();
    private final Object monitor2 = new Object();

    public BankAccount(int money) {
        this.money = money;
    }

    public void putMoney(int cash){
        synchronized (monitor){
            if (money > 0){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            money = money + cash; // read -> + -> write
            monitor.notifyAll();
        }
    }

    public int getCurrent(){
        return money;
    }

    public void takeMoney(int cash) {

        synchronized (monitor2){
            if (money < cash) {
                try {
                    monitor2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            money = money - cash;
            monitor2.notifyAll();
        }

    }

}

