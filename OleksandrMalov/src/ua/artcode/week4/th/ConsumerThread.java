package ua.artcode.week4.th;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Олександр on 19.07.2015.
 */
public class ConsumerThread  implements Runnable {

    private static final int COUNT = 10000;
    private BankAccount account;

    public ConsumerThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.getMoney(1);
        }

    }




    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();

        BankAccount bankAccount = new BankAccount(0);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ProducerThread(bankAccount));
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println(bankAccount.getCurrent());
    }}




class ProducerThread implements Runnable {

    private static final int COUNT = 10000;
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

    public int getCurrent(){
        return money;
    }

    public void getMoney(int cash) {
        if(money < cash) {
            return;
        }
        synchronized (monitor){
            while (cash < money){
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