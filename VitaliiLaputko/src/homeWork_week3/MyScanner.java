package homeWork_week3;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by ViTaLES on 18.07.2015.
 */
public class MyScanner implements IScanner {

    Reader reader;
    private char[] buffer = new char[1024];
    int startIndex;
    int endIndex;
    String delimited = " ";
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
    public int nextInt() {
        return 0;
    }

    @Override
    public String nextLine() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public void useDelimiter(String s) {

    }

    @Override
    public void close() {

    }
}
