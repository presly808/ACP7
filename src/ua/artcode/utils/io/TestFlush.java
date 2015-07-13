package ua.artcode.utils.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by serhii on 13.07.15.
 */
public class TestFlush {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("/home/serhii/dev/IdeaProjects/ACP7/temp/test.txt"));

        pw.println("some");

        pw.flush();

        System.out.println("End");
    }

}
