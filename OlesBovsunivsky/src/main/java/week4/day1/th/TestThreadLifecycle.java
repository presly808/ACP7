package week4.day1.th;

/**
 * Created by serhii on 18.07.15.
 */
public class TestThreadLifecycle {
    public static void main(String[] args) {

    }
}

class BankAccount{
    public int money;

    public void setMoney(int cash){
        synchronized (this){

            money = money-cash;
        }
    }
}
