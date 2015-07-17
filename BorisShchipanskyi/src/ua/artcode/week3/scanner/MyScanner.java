package ua.artcode.week3.scanner;

import java.io.*;
import java.util.Scanner;

/**
 * Created by boris on 7/15/15.
 */
public class MyScanner implements IScanner {
    Scanner sc = new Scanner(System.in);
    private Reader reader;
    private String nextLine;
    private String next;
    private int nextInt;
    private String scannerDelimiter = " ";
    private final String SPACE_DELIMITER = " ";
    private final String END_LINE_DELIMITER = "\n";


    public MyScanner(Reader reader) {
        this.reader = reader;
    }
    
    public MyScanner(String str){
        this.reader = new StringReader(str);
    }

    @Override
    public String next() {
        String retStr = next;
        next = null;
        return retStr;
    }

    @Override
    public int nextInt() {

        return 0;
    }

    @Override
    public String nextLine() {
        if(hasNext()){
            String retStr = next();
            nextLine = readBeforeDelimiter(END_LINE_DELIMITER);
            return (nextLine == null)? retStr: retStr+nextLine;

        }
        return null;
    }


    private String readBeforeDelimiter(String delimiter) {
        StringBuilder sb = new StringBuilder();
        try {
            int c = reader.read();
            if(c == -1){
                return null;
            }
            for (; c != -1 && !isEquals(c, delimiter) && !isEquals(c, END_LINE_DELIMITER); ) {
                sb.append((char) c);
                c = reader.read();

            }
            if(c != -1 && isEquals(c, END_LINE_DELIMITER)){
                sb.append((char)c);
            }

        } catch (IOException e) {
            return null;
        }
        return sb.toString();
    }
    private boolean isEquals(int c, String delimiter){
        return String.valueOf((char)c).equals(delimiter);
    }

    @Override
    public boolean hasNext() {
        next = (next == null )? readBeforeDelimiter(scannerDelimiter): next;
        return (next != null);
    }

    @Override
    public boolean hasNextInt() {

        return false;
    }

    @Override
    public void useDelimiter(String delimiter) {
        scannerDelimiter = delimiter;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

}
