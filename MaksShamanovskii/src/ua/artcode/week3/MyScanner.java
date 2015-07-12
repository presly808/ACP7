package ua.artcode.week3;

import java.io.IOException;
import java.io.Reader;

public class MyScanner {
    private Reader reader;
    private String buf;
    private char[] buffer = new char[1024];
    private int start = 0;
    private int end = 0;
    private int count = 0;
    private int index = 0;
    private String delimiter = " ";


    public MyScanner(Reader reader) {
        this.reader = reader;
        readInBuffer();
    }

    private void readInBuffer() {
        if (buf == null) {
            try {
                while (reader.ready()) {
                    buffer[index++] = (char) reader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            char[] temp = buf.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                buffer[i] = temp[i];
            }
        }
        findStart();
    }

    public MyScanner(String line) {
        buf = line;
        readInBuffer();
    }

    public String nextLine() {
        String res = "";
        for (int i = end; i < buffer.length; i++) {
            if (buffer[i] != '\u0000') {
                res += buffer[i];
            }
        }
        return res;
    }

    public String next() {
        findEnd(start);
        String res = "";
        for (int i = start; i < end; i++) {
            res += buffer[i];
        }
        start = end + 1;
        findStart();
        return res;
    }

    private void findStart() {
        for (; start < buffer.length; start++) {
            if (buffer[start] != ' ') {
                break;
            }
        }
    }

    private void findEnd(int startArr) {
        for (int i = startArr; i < buffer.length; i++) {
            if (buffer[i] == ' ' || buffer[i] == '\u0000') {
                end = i;
                break;
            }
        }
    }

    public int nextInt() {
        return 0;
    }


    public boolean hasNext() {
        if (buf == null) {
            try {
                return reader.ready();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String temp = buf.trim();
        return !temp.equals("");
    }

    public boolean hasNextInt() {
        if (buf == null) {

        }
        String temp = buf.trim();

        return false;
    }

}
