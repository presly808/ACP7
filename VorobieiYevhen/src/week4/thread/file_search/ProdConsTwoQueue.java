package week4.thread.file_search;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Джек on 22.07.2015.
 */
public class ProdConsTwoQueue {
    String fileName;
    String path;
    PrintWriter out;
    PriorityQueue<File> directories = new PriorityQueue<>(); //creates new each time???
    PriorityBlockingQueue<File> files = new PriorityBlockingQueue<>();
    long start = new Date().getTime();

    public ProdConsTwoQueue(String fileName, String path, PrintWriter out) {
        this.fileName = fileName;
        this.path = path;
        this.out = out;
        out.println("\n\t\t\t***Extra Producer Consumer Pattern Search File Algorithm***\n");
        directories.add(new File(path));

    }

    public PriorityQueue<File> getDirectories() {
        return directories;
    }

    public PriorityBlockingQueue<File> getFiles() {
        return files;
    }

    public long getStart() {
        return start;
    }

    public synchronized void iterFiles (PriorityQueue<File> directories, PriorityBlockingQueue<File> files) throws InterruptedException {
       /* if (this.files.size() > 0) {
            wait();
        }*/
        File directory;
        while ((directory = directories.poll()) != null) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    directories.add(file);
                    files.add(file);
                    notifyAll();
                }
                else {
                    files.add(file);
                    notifyAll();
                }
            }
        }
    }
    public synchronized void compareFiles (PriorityBlockingQueue<File> files, long start) throws InterruptedException {

        File file;
        while ((file = files.poll()) != null) {
            if (file.getName().contains(fileName)) {
                out.println(file.getAbsolutePath());
            }
            notifyAll();
        }
        long finish = new Date().getTime();
        long timePassed = finish - start;
        String time = "Operation took " + timePassed + " ms";
        System.out.println(time);
        out.println(time);
        out.flush();

    }
}
