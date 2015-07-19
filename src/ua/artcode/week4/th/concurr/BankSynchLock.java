package ua.artcode.week4.th.concurr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by serhii on 19.07.15.
 */
class BankSynchLock {

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
    private final Lock monitor = new ReentrantLock();
    private final Condition writeCondition = monitor.newCondition();
    private final Condition readCondition = monitor.newCondition();

    public BankAccount(int money) {
        this.money = money;
    }

    public void putMoney(int cash) {
        monitor.lock();
            while(money > 0){
                try {
                    writeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            money = money + cash; // read -> + -> write
            readCondition.signalAll();
        monitor.unlock();
    }

    public int getCurrent() {
        return money;
    }

    // monitor this
    public void withdrawMoney(int cash) {
        monitor.lock();
            while(money < cash){
                try {
                    readCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            money = money - cash;
            writeCondition.signalAll();
        monitor.unlock();
    }
}