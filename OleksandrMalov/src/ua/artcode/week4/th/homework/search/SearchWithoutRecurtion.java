package ua.artcode.week4.th.homework.search;

import java.io.File;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.Queue;

import java.io.FileNotFoundException;


public class SearchWithoutRecurtion {


    queue<string> taskList = new queue<string>();
    taskList.add(startDir);
    while (!taskList.empty())
    { string dir = taskList.first();
        taskList.popFirst();
        for each dirEntry in dir {
        if entry is directory taskList.add(entry);
        else processFile(entry);
    }
    }

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
            File dir = queue.element();
            queue.peek();

            for(File file : queue){
                if(file.isDirectory()) {
                    queue.addAll(Arrays.asList(file.listFiles()));
                    queue.remove(file);
                } else{
                    if (file.getName().equals(name))
                        file.getAbsolutePath();
                }
            }
        }
    }
}
