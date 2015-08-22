package ua.artcode.week3.scanner;

/**
 * Created by tokar on 15.07.2015.
 */
public interface IScanner {
    String nextLine();

    String next();

    int nextInt();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String delimiter);

    void close();
}
