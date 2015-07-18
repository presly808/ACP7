package ua.artcode.HomeWork.Week_3;

/**
 * Created by HOME on 17.07.2015.
 */
public interface IMyScanner {
    String next();
    int nextInt();
    String nextLine();
    boolean hasNext();
    boolean hasNextInt();
    void useDelimiter(String line);
    void close();
}
