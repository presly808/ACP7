package week4.threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Пользователь on 20.07.2015.
 */


class PeriodicalTask implements Runnable {
    private Calendar beginDate = Calendar.getInstance();
    private Calendar currentDate;
    private final Object TIMELABEL = 0;

    public Calendar getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Calendar beginDate) {
        this.beginDate = beginDate;
    }


    public Calendar getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Calendar currentDate) {
        this.currentDate = currentDate;
    }

    public void someAction() {
        System.out.println("I am working!!!!!!");
    }

    public void isSameDate(Calendar date) throws InterruptedException {
        if (beginDate.getTimeInMillis() / 100 > date.getTimeInMillis() / 100) {
                System.out.println("I am waiting for my time");
                }


            if (date == null) {
                throw new IllegalArgumentException("The date must not be null");
            }
            if (beginDate.getTimeInMillis() < date.getTimeInMillis()) {
                System.out.println("Time is up!!!");
            }
            if (beginDate.getTimeInMillis() / 100 == date.getTimeInMillis() / 100) {
                someAction();
            }
        }




    @Override
    public void run() {
        synchronized (TIMELABEL) {

            if (beginDate.getTimeInMillis() > ((new Date())).getTime()) {
                System.out.println("I am waiting for my time");
                try {
                    TIMELABEL.wait((beginDate.getTimeInMillis()-(new Date()).getTime()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (beginDate.getTimeInMillis() <  ((new Date())).getTime() / 100) {
                System.out.println("Time is up!!!");
            }
            if (beginDate.getTimeInMillis() / 100 ==  ((new Date())).getTime() / 100) {
                someAction();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Calendar currentDate = Calendar.getInstance();
        PeriodicalTask periodicalTask = new PeriodicalTask();
        //periodicalTask.beginDate.setTime();
        periodicalTask.beginDate.set(Calendar.MONTH, Calendar.JULY);
        periodicalTask.beginDate.set(Calendar.HOUR, 01);
        periodicalTask.beginDate.set(Calendar.MINUTE, 51);
        Thread waiter = new Thread(periodicalTask);
        System.out.println(periodicalTask.beginDate.getTime());
        waiter.start();

        //periodicalTask.isSameDate(currentDate);


    }

}




