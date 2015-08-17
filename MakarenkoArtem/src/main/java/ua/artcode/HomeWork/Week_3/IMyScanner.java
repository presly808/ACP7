package ua.artcode.HomeWork.Week_3;

import java.io.Closeable;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * Created by HOME on 17.07.2015.
 */
public interface IMyScanner extends Iterator<String>, Closeable {
    String next();
    int nextInt();
    String nextLine();
    boolean hasNext();
    boolean hasNextInt()throws InputMismatchException;
    void useDelimiter(String line);
    void close()throws IOException;
}
