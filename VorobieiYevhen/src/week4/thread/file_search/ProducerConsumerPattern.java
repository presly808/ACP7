package week4.thread.file_search;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class ProducerConsumerPattern {

    private String fileName;
    private String path;
    private PrintWriter out;
    private PriorityBlockingQueue<File> directories = new PriorityBlockingQueue<>(1); //creates new each time???
    private long start = new Date().getTime();
    private int count = 0;
    boolean state = true;

    public ProducerConsumerPattern(String fileName, String path, PrintWriter out) {
        this.fileName = fileName;
        this.path = path;
        this.out = out;
        out.println("\n\t\t\t***Producer Consumer Pattern Search File Algorithm***\n");
        directories.add(new File(path));
    }
    public void iterFiles () throws InterruptedException {
        search(new File(path));
        state = false;
    }
    public void compareFiles () throws InterruptedException {
        File files;
        while (state | directories.peek() != null) {
            files = directories.take();
            System.out.println("poll " + files.getAbsolutePath());
            System.out.println(directories.size());
             if (files.getName().endsWith(fileName)) {
                 count++;
                 out.println(files.getAbsolutePath());
                 out.flush();
             }
        }
        long finish = new Date().getTime();
        long timePassed = finish - start;
        String time = "Operation took " + timePassed + " ms";
        String filesFound = count + " files found";
        System.out.println(time + "\n" + filesFound);
        out.println(time + "\n" + filesFound);
        out.flush();
    }
    private  void search (File file) {
        for (File item : file.listFiles()) {
            if (item.isDirectory()) {
                search(item);
            } else {
                System.out.println("add " + item.getAbsolutePath());
                System.out.println(directories.size());
                 directories.add(item);
            }
        }
    }
}
