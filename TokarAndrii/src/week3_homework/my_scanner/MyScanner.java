package week3_homework.my_scanner;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class MyScanner implements Iterator, Closeable {

    private Reader reader;
    private String ScannerString;
    private char[] scannerBuffer;
    private int indexScannerBuffer;


    public MyScanner(Reader reader) {
        this.reader = reader;

    }

    public MyScanner(String scannerString) {
        ScannerString = scannerString;
    }


    public void start() {

        try {
            if (hasNext() == true) ;

            next();


        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean hasNext() {

        read();

        if (scannerBuffer[indexScannerBuffer] == '\u0000') {
            return true;
        }

        return false;
    }


    public char[] read() {
        try {
            while (reader.ready() == true)
                scannerBuffer[indexScannerBuffer] = (char) reader.read();
            indexScannerBuffer++;


        } catch (IOException e) {
            e.printStackTrace();
        }


        return scannerBuffer;
    }

    @Override
    public String next() {
        scannerBuffer = read();
        String buff = scannerBuffer.toString();
        String[] buffMas = buff.split(" ");


        return buffMas[0];
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
