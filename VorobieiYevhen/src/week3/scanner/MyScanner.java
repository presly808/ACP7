package week3.scanner;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class MyScanner implements IScanner {

    private Reader reader;
    private String string;
    private ArrayList<Character> readerList;
    private String[] clipboard;
    private String delimiter = " ";
    private int position = 0;

    public MyScanner(Reader reader) {
        this.reader = reader;

        readerToStringArray(reader);

    }

    public MyScanner(String string) {
        this.string = string;

        clipboard = string.split(delimiter);

    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    private void readerToStringArray (Reader reader) {

        readerToCharList(reader);

        charListToString();

        clipboard = string.split(delimiter);
    }

    private void readerToCharList(Reader reader) {
        try {
            while (reader.ready()) {
                readerList.add((char)reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void charListToString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < readerList.size(); i++) {
            sb.append(readerList.get(i));  //.toString
        }
        string = sb.toString();
    }


    @Override
    public String next() {
        if (hasNext()) {
            String next = clipboard[position];
            position++;

            return next;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int nextInt() {
        if (hasNext()) {
            if (hasNextInt()) {
            int number = Integer.parseInt(clipboard[position]);
            position++;
            return number;
            } else {
                throw new InputMismatchException();
            }
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String nextLine() {
        if (hasNext()) {
            StringBuilder sb = new StringBuilder();
            if (position != 0) {
                sb.append(delimiter);
            }
            while(position < clipboard.length - 1) {

                sb.append(next() + delimiter);

            }
            sb.append(next());
            String line = sb.toString();
            return line;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasNext() {
        if (clipboard == null) {
            return false;
        } else if (position < clipboard.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasNextInt() {
       if (hasNext() & isDigit()) {
           return  true;
       }
        return false;
    }

    private boolean isDigit() {

        char[] digits = next().toCharArray();
        position--;

        for (int i = 0; i < digits.length; i++) {
            if (!Character.isDigit(digits[i])){
                return  false;
            }
        }
        return  true;
    }

    @Override
    public void useDelimiter(String newDelimiter) {

        StringBuilder sb = new StringBuilder();
        while (position < clipboard.length) {
            sb.append(delimiter + clipboard[position]);
            position++;
        }
        string = sb.toString();
        setDelimiter(newDelimiter);
        clipboard = string.split(delimiter);
        position = 0;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                readerList = null;
                clipboard = null;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            clipboard = null;
            string = null;
        }
    }

}
