package homeWork_week3;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;

/**
 * Віталій Лапутько джавва класс
 */
public class MyScanner implements IScanner {

    Reader reader;
    private char[] buffer = new char[1024];
    private int startIndex;
    private int endIndex;
    private String delimited = " ";
    private String next;
    private String head;


    public MyScanner(String source) {
        this(new StringReader(source));

    }

    public MyScanner(Reader reader) {
        this.reader = reader;
        fillBuffer(buffer);
        head = getWord();

        //next = next();
    }

    private void fillBuffer(char[] buffer) {
        try {
            endIndex = reader.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        startIndex = 0;
    }


    @Override
    public String next() {
        String temp = head;
        head = getWord();

        return temp;
    }

    public String getWord(){
        StringBuilder sb = new StringBuilder();

        if (endIndex == -1) {
            next = null;
            return next;
        } else {
            skipDelimiter();
            for (char element = buffer[startIndex]; element != '\n' && !isDelimiter(element) && endIndex != -1;) {
                if (startIndex == endIndex) {
                    fillBuffer(buffer);
                } else {
                    sb.append(element);
                }
                element = buffer[++startIndex];
            }

        }

        return (sb.length() == 0) ? null : sb.toString();
    }

    public boolean isDelimiter(char element){
        return delimited.equals(String.valueOf(element));
    }

    public void skipDelimiter(){
        while (isDelimiter(buffer[startIndex]) && endIndex != -1){
            startIndex++;

            if (startIndex == endIndex) {
                fillBuffer(buffer);
            }
        }
    }


    @Override
    public boolean hasNext() {
        return head != null;
    }


    @Override
    public String nextLine() {
        useDelimiter("\n");

        return next();
    }


    @Override
    public int nextInt() {
        String next = next();
        if(isInteger(next)){
            return Integer.parseInt(next);
        }

        throw new InputMismatchException(next + " is not a number");
    }

    private boolean isInteger(String next) {
        for (int i = 0; i < next.length(); i++) {
            if(!Character.isDigit(next.charAt(0))){
                return false;
            }
        }

        return true;
    }


    @Override
    public boolean hasNextInt() {
        return next != null;
    }


    @Override
    public void useDelimiter(String s) {
        delimited = s;
    }


    @Override
    public void close() {
        buffer = null;

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
