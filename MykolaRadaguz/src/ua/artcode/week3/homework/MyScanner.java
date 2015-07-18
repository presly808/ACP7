package ua.artcode.week3.homework;

import java.io.*;
import java.util.Scanner;

/**
 * Created by pikolo on 15.07.15.
 */
public class MyScanner implements IScanner {

    private Reader input;
    private String delimiter;
    private char[] buff = new char[1024];
    private int startPos = 0;
    private int endPos = 0;

    public MyScanner(Reader reader) {
        this.input = reader;
    }

    public MyScanner(String source) {
        input = new StringReader(source);
    }

    public void fillInBuff() {
        try {
            endPos = input.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String next() {
        if (startPos > endPos) {
            fillInBuff();
        }

        String next = "";
        char read = 0;
        int iter = startPos;
        try {
            while ((read = (char) input.read()) != -1 || read != ' ') {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return next.isEmpty() ? null : next;
    }

    public void remove() {

    }

    public int nextInt() {
        return 0;
    }

    public String nextLine() {
        return null;
    }

    public boolean hasNext() {
        return true;
    }

    public boolean hasNextInt() {
        return true;
    }

    public void useDelimiter(String delimiter) {

    }

    public void close() {

    }

}
