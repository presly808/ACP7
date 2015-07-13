package ua.artcode.week3.scan;

import java.io.IOException;
import java.io.Reader;
import java.util.NoSuchElementException;

public class MyScanner implements IScanner {
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

    @Override
    public String nextLine() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            String res = "";
            int i = end;
            while (buffer[i] != '\u0000') {
                res += buffer[i++];
            }
            start = i;
            return res;
        }
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            findEnd(start);
            String res = "";
            for (int i = start; i < end; i++) {
                res += buffer[i];
            }
            start = end;
            findStart();
            return res;
        }
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

    @Override
    public int nextInt() {
        String res = "";
        if (hasNextInt()) {
            for (int i = start; i < end; i++) {
                if (buffer[i] > '\u0030' && buffer[i] < '\u0039') {
                    res += buffer[i];
                } else {
                    throw new NumberFormatException();
                }
            }
        }
        start = end;
        findStart();
        return Integer.parseInt(res);
    }

    @Override
    public boolean hasNext() {
        return buffer[start] != '\u0000';
    }

    @Override
    public boolean hasNextInt() {
        if (start == '\u0000') {
            return false;
        }
        findEnd(start);
        for (int i = start; i < end; i++) {
            if (buffer[i] < '\u0030' || buffer[i] > '\u0039') {
                return false;
            }
        }
        return true;
    }

    @Override
    public void useDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
