package week4.threads.home.task;

import java.util.Calendar;

/**
 * Created by Пользователь on 20.07.2015.
 */


class PeriodicalTask implements Runnable {
    private Calendar beginDate = Calendar.getInstance();
    private final Calendar currentDate = Calendar.getInstance();
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
            if (beginDate.getTimeInMillis() > currentDate.getTimeInMillis()) {
                System.out.println("I am waiting for my time");
                try {
                    TIMELABEL.wait((beginDate.getTimeInMillis() - currentDate.getTimeInMillis()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (beginDate.getTimeInMillis()/100== currentDate.getTimeInMillis()/100) {
                someAction();
            }

            if (beginDate.getTimeInMillis() / 100 < currentDate.getTimeInMillis() / 100) {
                System.out.println("Time is up!!!");
            }

        }
    }



    public static void main(String[] args) throws InterruptedException {
        Calendar currentDate = Calendar.getInstance();
        PeriodicalTask periodicalTask = new PeriodicalTask();
        //periodicalTask.beginDate.setTime();
        periodicalTask.beginDate.set(Calendar.MONTH, Calendar.JULY);
        periodicalTask.beginDate.set(Calendar.HOUR, 02);
        periodicalTask.beginDate.set(Calendar.MINUTE, 18);
        Thread waiter = new Thread(periodicalTask);
        System.out.println(periodicalTask.beginDate.getTime());
        System.out.println(periodicalTask.currentDate.getTime());
        waiter.start();

        //periodicalTask.isSameDate(currentDate);


    }

}




