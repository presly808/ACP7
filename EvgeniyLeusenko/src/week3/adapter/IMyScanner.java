package week3.adapter;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Пользователь on 17.07.2015.
 */
public interface IMyScanner extends Iterator<String>, Closeable {
    int nextInt();
    String nextLine();
    boolean hasNextInt();
    void useDelimiter(String delimiter);

}
