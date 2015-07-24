package ua.artcode.week4.th.homework.scheduler;


public class SomeThread implements Runnable{

    private String name;

    public SomeThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {

        System.out.println(name);
    }
}
