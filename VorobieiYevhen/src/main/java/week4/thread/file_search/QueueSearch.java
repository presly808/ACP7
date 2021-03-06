package week4.thread.file_search;

import java.io.*;
import java.sql.Time;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Timer;

/**
 * Created by Джек on 21.07.2015.
 */
public class QueueSearch {
    private String fileName;
    private String path;
    private PrintWriter out;
    private int count = 0;

    public QueueSearch(String fileName, String path, PrintWriter out) {
        this.fileName = fileName;
        this.path = path;
        this.out = out;
    }

    public void searchFileQueue() {
        long start = new Date().getTime();
        Queue<File> directories = new PriorityQueue<>();
        out.println("\n\t\t\t***Queue Search File Algorithm***\n");

        directories.add(new File(path));
        File directory;
        while ((directory = directories.poll()) != null) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    directories.add(file);
                }
                if (file.getName().endsWith(fileName)) {
                    out.println(file.getAbsolutePath());
                    count++;
                }
            }
        }
        long finish = new Date().getTime();
        long timePassed = finish - start;
        String time = "Operation took " + timePassed + " ms";
        String filesFound = count + " files found";
        System.out.println(time + "\n" + filesFound);
        out.println(time + "\n" + filesFound);
        out.flush();

       // out.close();
    }
}