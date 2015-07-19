package ua.artcode.week3.home;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by serhii on 18.07.15.
 */
public class MyScanner implements IScanner {

    private Reader input;
    private String delimeter;
    private char[] buff = new char[1024];
    private int startPos = 0;
    private int endPos = 0;

    public MyScanner(String source) {
        input = new StringReader(source);
    }

    public MyScanner(Reader input) {
        this.input = input;
    }

    public void fillInBuff() {
        try {
            endPos = input.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String next() {
        if (startPos >= endPos) {
            fillInBuff();
        }

        String next = "";
        int iter = startPos;
        while (iter < endPos && buff[iter] != ' ') {
            if (startPos == buff.length) {
                fillInBuff();
                iter = 0;
            }

            next += buff[iter];
            iter++;
        }

        startPos = iter + 1;

        return next.isEmpty() ? null : next;

    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public String nextLine() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasNextInt() throws InputMismatchException {
        return false;
    }

    @Override
    public void useDelimiter(String delimiter) {

    }

    @Override
    public void close() throws IOException {

    }
}
