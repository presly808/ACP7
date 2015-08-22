package week4.day1;

import java.util.ArrayList;
import java.util.List;


public class BankSynch {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<Thread>();

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

    public ProducerThread() {

    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            account.putMoney(2);
            account.setMoney(3);
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
            while (money>0){
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

    public void setMoney(int cash){

        synchronized (monitor){
            while (money<cash){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            money = money-cash;
            monitor.notifyAll();

        }
    }

    public int getCurrent(){
        return money;
    }

}
