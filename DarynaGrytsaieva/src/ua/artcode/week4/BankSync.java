package ua.artcode.week4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daryna on 19-Jul-15.
 */
public class BankSync {
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
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ConsumerThread(bankAccount));
            threadList.add(thread);
            thread.start();
        }

        //Thread.sleep(2000);

        System.out.println(bankAccount.getCurrent());
    }

}

class ProducerThread implements Runnable {
    private static final int COUNT = 100;
    private BankAccount account;

    public ProducerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            account.putMoney(1);
        }
    }
}

class ConsumerThread implements Runnable {
    private static final int COUNT = 100;
    private BankAccount account;

    public ConsumerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.getMoney(20);
    }
}

class BankAccount {

    private int money;
    private final Object monitor = new Object();

    public BankAccount(int money) {
        this.money = money;
    }

    public void putMoney(int cash) {
        synchronized (this) {  // or monitor
            money = money + cash; //read -> + -> write
        }
    }

    public int getMoney(int money) {
        synchronized (monitor) {
            if (this.money >= money) {
                this.money = this.money - money;
                return money;
            } else {
                System.out.println("Not enough money on account");
                return 0;
            }
        }
    }



    public int getCurrent() {
        return money;
    }
}
