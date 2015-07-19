package week3_homework.my_scanner;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* String next() - чтение одного слова в строке
   int nextInt() - чтение целого числа из строки или InputMismatchException
   String nextLine() - чтение всей строки
   boolean hasNext() - определение наличия в потоке данных
   boolean hasNextInt() - определение наличия в потоке целого int числа
   useDelimiter(String) - использует разделитель
   close() - закрытие сканнера, теперь нельзя использовать и NoSuchElementException*/
public final class MyScanner implements Iterator, Closeable {

    private Reader reader;
    private String ScannerString;
    private char[] scannerBuffer;
    private int indexScannerBuffer;


    public MyScanner(Reader reader) {
        this.reader = reader;

        start();

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

        if (scannerBuffer[indexScannerBuffer] != '\u0000') {
            return true;
        }

        return false;
    }


    public char[] read() {
        try {
            while (reader.ready() == true)
                scannerBuffer[indexScannerBuffer] = (char) reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        indexScannerBuffer++;

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
