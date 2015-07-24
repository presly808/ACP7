package ua.artcode.week4.th.homework.search;

import java.io.File;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
        Queue<File> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            File dir = queue.poll();
            for(File file : dir.listFiles()){
                if(file.isDirectory()) {
                    queue.addAll(Arrays.asList(file.listFiles()));
                } else{
                    if (file.getName().equals(name))
                        file.getAbsolutePath();
                }
            }
        }
    }
}
