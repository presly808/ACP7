package ua.artcode.week3.scanner;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

/*String next() - чтение одного слова в строке
        int nextInt() - чтение целого числа из строки или InputMismatchException
        String nextLine() - чтение всей строки
        boolean hasNext() - определение наличия в потоке данных
        boolean hasNextInt() - определение наличия в потоке целого int числа
        useDelimiter(String) - использует разделитель
        close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException*/

/**
 * Created by tokar on 15.07.2015.
 */
public class MyScanner implements IScanner{
    private static final int BUFFER_SIZE = 1024;
    private Reader reader;
    private String line;
    private char[] buffer = new char[BUFFER_SIZE];
    int position =0;

    public MyScanner(Reader reader) {
        this.reader = reader;
        readInBuffer();
    }

    public MyScanner(String line) {
        this.line = line;

    }

    public void readInBuffer(){
        try {
            while(reader.ready()){ //Tells whether this stream is ready to be read.!!Blocked
                buffer[position]= (char)reader.read();  //@return The character read, as an integer in the range 0 to 65535!!Blocked
                position++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String nextLine() {
        return null;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public void useDelimiter(String delimiter) {

    }

    @Override
    public void close() {

    }
}
