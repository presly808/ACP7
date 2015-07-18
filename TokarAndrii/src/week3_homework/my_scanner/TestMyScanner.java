package week3_homework.my_scanner;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Пользователь on 17.07.15.
 */
public class TestMyScanner {


    public static void main(String[] args) {

        Reader reader = new Reader() {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };


        MyScanner myScanner = new MyScanner(reader);

        myScanner.hasNext();
    }
}
