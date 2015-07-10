package ua.artcode.utils;

//import classWork.week5.day2.IOHelper;

import java.io.*;
import java.util.Scanner;

/**
 * Created by boris on 5/30/15.
 */
public class FileUtils {
    public static void showFolderContent(File file, String step){
        System.out.println(step + file.getName());
        if(file.isDirectory()){
            for(File f: file.listFiles()){
                showFolderContent(f, step +"----");
            }
        }
    }

    public static void findByName(File file, String key){
        if(file.getName().contains(key)){
            System.out.println(file.getAbsolutePath());
        }
        if (file.isDirectory()){
            for(File f: file.listFiles()){
                findByName(f, key);
            }
        }
    }

    public static String findByNameWithRes(File file, String key){
        String res = "";
        if(file.getName().contains(key)){
           res = file.getAbsolutePath() + "\n";
        }
        if (file.isDirectory()){
            for(File f: file.listFiles()){
                res += findByNameWithRes(f, key);
            }
        }
        return res;
    }

    public static boolean isFile(String filePath){
        File file = new File(filePath);
        return file.isFile();

    }
    public static boolean isDirectory(String filePath){
        File file = new File(filePath);
        return file.isDirectory();

    }

    public static void copy(String sourcePath, String destinationPath) {
        File source = new File(sourcePath);
        File dest = new File(destinationPath);

        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
            input.close();
            output.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

    public static String getFileContent(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()){
            sb.append(sc.nextLine()+ "\n");
        }
        return sb.toString();
    }

    public static File changeLocation(String path){
        if(isDirectory(path))
        return new File(path);
        return new File(".");
    }

    public static String getPath(File file){
        return file.getPath();

    }
    public static String getAbsolutePath(File file){
        return file.getAbsolutePath();
    }

}
