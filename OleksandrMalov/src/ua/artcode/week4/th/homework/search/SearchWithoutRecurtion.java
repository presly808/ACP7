package ua.artcode.week4.th.homework.search;

import java.io.File;

import java.util.*;

import java.io.FileNotFoundException;


public class SearchWithoutRecurtion {


    public static void main(String[] args) throws FileNotFoundException {

        String name = "pictures";
        String rootDir = "d://";
        File root = new File(rootDir);

        if (!root.exists()) {
            throw new FileNotFoundException("Cannot access " + root.getPath() + ": No such file");
        }

        if (!root.isDirectory()){
            throw new IllegalArgumentException("Cannot list content of " + root.getPath() + ": Not a directory");
        }
        ArrayList<String> results = new ArrayList();
        Queue<File> queue = new PriorityQueue<>();
        queue.add(root);
        while(!queue.isEmpty()){
            File firstDir = queue.poll();
            for(File file : firstDir.listFiles()){
                if(file.isDirectory()) {
                    queue.add(file);
                } else {
                    if (file.getName().equals(name)){
                        results.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
