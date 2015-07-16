package ua.artcode.week3.scanner;

public interface IScanner {

    String next();

    int nextInt();

    String nextLine();

    boolean hasNext();

    boolean hasNextInt();

    void useDelimiter(String);

    void close();
}
