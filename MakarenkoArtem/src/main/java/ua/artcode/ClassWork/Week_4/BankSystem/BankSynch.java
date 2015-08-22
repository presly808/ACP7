package ua.artcode.ClassWork.Week_4.BankSystem;

import java.util.ArrayList;
import java.util.List;


public class BankSynch {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        BankAccount bankAccount = new BankAccount(0);
        for (int i = 0; i < 5; i++) {
            Thread producer = new Thread(new ProducerThread(bankAccount));
            Thread consumer = new Thread(new ConsumerThread(bankAccount));
            threadList.add(producer);
            threadList.add(consumer);

            producer.start();
            consumer.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println(bankAccount.getCurrent());
    }


}

class ConsumerThread implements Runnable {

    private static final int COUNT = 10000;
    private BankAccount account;

    public ConsumerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            account.withdrawMoney(100);
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

    public BankAccount(int money) {
        this.money = money;
    }

    public void putMoney(int cash) {
        synchronized (monitor) {
            while(money > 0){
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

    public int getCurrent() {
        return money;
    }

    // monitor this
    public void withdrawMoney(int cash) {
        synchronized (monitor) {
            while(money < cash){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            money = money - cash;
            monitor.notifyAll();
        }

    }
}
