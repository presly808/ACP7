package ua.artcode.ClassWork.Week_3.adapter.remote;

import java.io.File;

/**
 * Created by serhii on 12.07.15.
 */
public class TestRelativePath {
    public static void main(String[] args) {
        File file = new File("VorobieiYevhen/resources/Commands.txt");
        System.out.println(file.exists());
    }
}
