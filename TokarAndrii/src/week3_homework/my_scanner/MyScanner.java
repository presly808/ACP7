package week3_homework.my_scanner;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;

public final class MyScanner implements Iterator, Closeable {

    private Reader in;
    private String ScannerString;
    private char[] scannerBuffer = new char[500];
    private int indexStart = 0;
    private int indexEnd = 0;


    public MyScanner(String source) {
        in = new StringReader(source);
    }

    public MyScanner(Reader input) {
        this.in = input;
    }

    @Override
    public boolean hasNext() {

        int curr = indexStart;

        if (curr == ' ') {
            return false;
        }

        if (indexStart >= indexEnd) {
            readInBuffer();

        }
        String next = "";

        while (curr < indexEnd && scannerBuffer[curr] != ' ') {
            if (indexStart == scannerBuffer.length) {
                readInBuffer();
                indexStart = 0;
            }

            next += scannerBuffer[curr];
            curr++;


        }
        indexStart = curr + 1;

        return next.isEmpty() ? false : true;

    }

    @Override
    public Object next() {
        return null;
    }


    public void readInBuffer() {
        try {
            indexEnd = in.read(scannerBuffer);
            scannerBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove() {

    }

    public int nextInt() {
        return 0;
    }


    public String nextLine() {
        return "";
    }


    public boolean hasNextInt() {
        return false;
    }

    public String useDelimiter(String string) {
        return "";
    }

    public void close() {

    }


}
