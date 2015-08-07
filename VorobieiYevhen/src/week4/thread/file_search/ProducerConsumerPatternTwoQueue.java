package week4.thread.file_search;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerPatternTwoQueue {

    String fileName;
    String path;
    PrintWriter out;
    PriorityQueue<File> directories = new PriorityQueue<File>();
    PriorityBlockingQueue<File> directories2 = new PriorityBlockingQueue<File>();//creates new each time???
    long start = new Date().getTime();

    public ProducerConsumerPatternTwoQueue(String fileName, String path, PrintWriter out) {
        this.fileName = fileName;
        this.path = path;
        this.out = out;
        out.println("\n\t\t\t***Producer Consumer Pattern \"Two queue\" Search File Algorithm***\n");
        directories.add(new File(path));

    }

   public long getStart() {
        return start;
    }

   public synchronized void iterFiles () throws InterruptedException {
        File files;
        while ((files = directories.poll()) != null) {

            if (files.isDirectory()) {
                for (File file : files.listFiles()) {
                    directories.add(file);
                    directories2.add(file);
                }
            }
        }
   }
    public synchronized void compareFiles (long start) throws InterruptedException {
        File files;
        while ((files = directories2.poll()) != null) {
             if (files.getName().endsWith(fileName)) {
                 out.println(files.getAbsolutePath());
                 out.flush();
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
