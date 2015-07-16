package ua.artcode.week3.scanner;

public interface IScanner {

    String next();

    int nextInt(int radix);

    String nextLine();

    boolean hasNext();

    boolean hasNextInt(int radix);

    void useDelimiter(String delimeter);

    void close();
}
