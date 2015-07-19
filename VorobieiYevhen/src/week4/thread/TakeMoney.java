package week4.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Джек on 19.07.2015.
 */
public class TakeMoney {



       public static void main(String[] args) throws InterruptedException {
            List<Thread> threadList = new ArrayList<>();

            BankAccount bankAccount = new BankAccount(0);
            for (int i = 0; i < 10; i++) {
                Thread put = new Thread(new ProducerPutThread(bankAccount));
                Thread take = new Thread(new ProducerTakeThread(bankAccount));
                threadList.add(put);
                threadList.add(take);
                take.start();
                put.start();
            }

            for (Thread thread : threadList) {
                thread.join();
            }

            System.out.println(bankAccount.getCurrent());
        }


    }

    class ProducerPutThread implements Runnable {

        private static final int COUNT = 100000;
        private BankAccount account;

        public ProducerPutThread(BankAccount account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                account.putMoney(10);
            }
        }
    }
class ProducerTakeThread implements Runnable {

    private static final int COUNT = 100000;
    private BankAccount account;

    public ProducerTakeThread(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            account.pullMoney(10);
        }
    }
}

    class BankAccount {

        private int money;
        private final Object monitor = new Object();


        public BankAccount(int money) {
            this.money = money;
        }

        public void pullMoney(int cash){
            synchronized (monitor){
                if (money < cash) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                money = money - cash; // read -> + -> write
                monitor.notifyAll();
            }
        }

        public  void putMoney(int cash){
            synchronized (monitor){
                while(money > 0) {
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


}
