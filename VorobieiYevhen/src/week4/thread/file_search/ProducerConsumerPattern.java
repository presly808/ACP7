package week4.thread.file_search;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerPattern {

    String fileName;
    String path;
    PrintWriter out;
    PriorityBlockingQueue<File> directories = new PriorityBlockingQueue<>(); //creates new each time???
    long start = new Date().getTime();

    public ProducerConsumerPattern(String fileName, String path, PrintWriter out) {
        this.fileName = fileName;
        this.path = path;
        this.out = out;
        out.println("\n\t\t\t***Producer Consumer Pattern Search File Algorithm***\n");
        directories.add(new File(path));

    }

    public PriorityBlockingQueue<File> getDirectories() {
        return directories;
    }

   public long getStart() {
        return start;
    }

    public synchronized void iterFiles (PriorityBlockingQueue<File> directories) throws InterruptedException {
        File files;
        while ((files = directories.peek()) != null) {

            if (files.isDirectory()) {
                for (File file : files.listFiles()) {
                    directories.add(file);

                }
                if (directories.size() >= 1) {
                    notifyAll();
                    wait();
                }

            } else {
                if (directories.size() >= 1) {
                    notifyAll();
                    wait();
                }

            }
        }
    }
    public synchronized void compareFiles (PriorityBlockingQueue<File> directories, long start) throws InterruptedException {
        File files;
        while ((files = directories.poll()) != null) {
             if (files.getName().endsWith(fileName)) {
                 out.println(files.getAbsolutePath());
                 out.flush();
                 notifyAll();
                 if (directories.size() > 0) {
                    wait(); //if iterThread alive
                 }

             } else {
                 notifyAll();
                 if (directories.size() > 0) {
                   wait();//if iterThread alive
                 }
             }
        }


        long finish = new Date().getTime();
        long timePassed = finish - start;
        String time = "Operation took " + timePassed + " ms";
        System.out.println(time);
        out.println(time);
        out.flush();

    }
}
