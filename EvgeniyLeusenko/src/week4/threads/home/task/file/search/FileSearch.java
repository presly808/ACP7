package week4.threads.home.task.file.search;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Пользователь on 22.07.2015.
 */
public class FileSearch {
    private String fileName; //с расширением
    private File searchingDirectory;
    private Deque<File> queue = new ArrayDeque<File>();
    private Deque<File> queueTemp = new ArrayDeque<File>();



    public FileSearch(String fileName, File searchingDirectory) throws NoDirectoryException {
        this.searchingDirectory = searchingDirectory;
        if (searchingDirectory.isDirectory()) {
            searchingDirectory = searchingDirectory;
        } else {
            throw new NoDirectoryException("Имя папки некорректно");
        }

        if (fileName.contains(".")) {
            this.fileName = fileName;
        } else {
            throw new NoDirectoryException("Имя файла некорректно");
        }

    }

    public void queueSearch() {
        queueTemp.addLast(searchingDirectory);
        File temp = searchingDirectory;
        while (!queueTemp.isEmpty()) {
            temp = queueTemp.getFirst();
            queueTemp.removeFirst();
            if (temp.isDirectory()) {
                for (File i : temp.listFiles()) {
                    queueTemp.addLast(i);
                }
            } else {
                queue.addFirst(temp);
            }

        }
    }


    public void show() {

        for(File i:queue){
            System.out.println(i.toString());
        }
    }
    public void search() {
        String message="";
        for(File i:queue){
            if(i.toString().contains(fileName)){
            message="Папка "+searchingDirectory+" содержит файл "+fileName;
            break;}
            else{
                message="Папка "+searchingDirectory+" не содержит файл "+fileName;

            }
        }
        System.out.println(message);
    }
    public Integer searchCount(String fileName, File searchingDirectory) {
        Integer iter=0;
        queueTemp.addLast(searchingDirectory);
        File temp = searchingDirectory;
        while (!queueTemp.isEmpty()) {
            temp = queueTemp.getFirst();
            queueTemp.removeFirst();
            if (temp.isDirectory()) {
                for (File i : temp.listFiles()) {
                    queueTemp.addLast(i);
                }
            } else {
                queue.addFirst(temp);
            }

        }
        for(File i:queue){
            if(i.toString().contains(fileName)){
                iter++;}


        }
        return iter;
    }

}

