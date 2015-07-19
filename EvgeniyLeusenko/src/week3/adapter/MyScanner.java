package week3.adapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Пользователь on 17.07.2015.
 */
public class MyScanner implements IMyScanner {
    private final int DEFAULT_CAPACITY = 1024;
    private Reader reader;
    private String bufferString;
    private char[] bufferChar=new char[DEFAULT_CAPACITY];
    private boolean closed = false;
    private String result;


    public MyScanner(Reader reader) throws IOException {
        this.reader = reader;
        BufferedReader br=new BufferedReader(reader);
        while(br.read()!=-1){
            bufferChar=br.readLine().toCharArray();
        }
    }
 public MyScanner(String buffer) {
        bufferChar=buffer.toCharArray();

    }

    @Override
    public void close() throws IOException {
        if(!closed) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean hasNext() {
        return bufferChar[0]!= '\u0000';

    }

    @Override
    public String next() {
        result=String.valueOf(bufferChar);
        int i=0;
            while(bufferChar[i]==' '){
                i++;
                result=String.valueOf(bufferChar[i]);
                return result;
            }
        return result;
    }

    @Override
    public int nextInt() {
        int resInt[]=new int[DEFAULT_CAPACITY];
        for(int i=0;i<=bufferChar.length;i++) {
            if (bufferChar[i] > '\u0030' && bufferChar[i] < '\u0039')
                resInt[i] = bufferChar[i];
            //System.out.println(bufferChar[i]);
        }
        return 0;
    }

    @Override
    public String nextLine() {
        return String.valueOf(bufferChar);
    }

    @Override
    public boolean hasNextInt() {
        for(int i=0;i<=bufferChar.length;i++){
            if(bufferChar[i] > '\u0030' && bufferChar[i] < '\u0039')
                return true;
        }
        return false;

    }

    @Override
    public void useDelimiter(String delimiter) {


    }
}
