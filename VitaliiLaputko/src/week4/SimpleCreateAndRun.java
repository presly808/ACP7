package week4;

/**
 * Created by ViTaLES on 18.07.2015.
 */
public class SimpleCreateAndRun {

    //MAIN THREAD
    public static void main(String[] args) {

        MyOutPrintThread myThread = new MyOutPrintThread();
        myThread.start(); //start separate thread (parallel action)

        MyOutPrintThread myThread1 = new MyOutPrintThread();
        myThread.start(); //start separate thread (parallel action)


        for (int i = 0; i < 1000; i++) {
            showThreadInfo(i);
        }




    }

    public static void showThreadInfo(int i){
        Thread current = Thread.currentThread();
        System.out.printf("id %s, name %s, priority %s, count %d",
                current.getId(),
                current.getName(),
                current.getPriority(), i);
    }

}

class MyOutPrintThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("My thread " + i);
        }
    }
}
