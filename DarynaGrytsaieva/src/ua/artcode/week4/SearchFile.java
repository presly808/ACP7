package ua.artcode.week4;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Daryna on 23-Jul-15.
 */
public class SearchFile {
    final static String ROOT_DIR = "C:\\Users\\Daryna\\workspace";

    public static void main(String[] args) {
        SearchFile sf = new SearchFile();
        System.out.println(sf.find("some.txt"));
    }


    public String find(String fileName) {
        String path = null;
        File rootFile = new File(ROOT_DIR);


        Queue<File> files = new LinkedList<File>();

        File[] temp = rootFile.listFiles();
        for (File f : temp) {
            files.add(f);
        }
        while (!files.isEmpty()) {
            if (files.peek().getName().equals(fileName)) {
                path = files.peek().getPath();
            }
            if (files.peek().isDirectory()) {
                for (File f : files.peek().listFiles())
                    files.add(f);
            }
            files.remove();
        }

        return path != null ? path : "File not found.";


    }
}
