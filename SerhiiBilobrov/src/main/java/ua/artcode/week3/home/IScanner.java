package ua.artcode.week3.home;

import java.io.Closeable;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;


public interface IScanner extends Iterator<String>, Closeable {
    String next();

    int nextInt();

    String nextLine();

    boolean hasNext();

    boolean hasNextInt() throws InputMismatchException;

    void useDelimiter(String delimiter);

    void close() throws IOException;

}

