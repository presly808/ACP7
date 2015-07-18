package ua.artcode.week3.scanner;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by boris on 7/15/15.
 */
public interface IScanner extends Iterator<String>, Closeable {
    String next() ;
    int nextInt();
    String nextLine();
    boolean hasNext();
    boolean hasNextInt() throws InputMismatchException;
    void useDelimiter(String delimiter);
    void close() throws IOException;

}
