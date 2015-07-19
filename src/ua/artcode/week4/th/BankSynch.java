package ua.artcode.week4.th;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class BankSynch {

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

    public void putMoney(int cash){
        synchronized (monitor){
            money = money + cash; // read -> + -> write
        }
    }

    public int getCurrent(){
        return money;
    }

}
