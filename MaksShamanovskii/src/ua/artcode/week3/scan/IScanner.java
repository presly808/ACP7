package ua.artcode.week3.scan;

public interface IScanner {

    String nextLine();

    String next();

    int nextInt();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String delimiter);

    void close();
}
