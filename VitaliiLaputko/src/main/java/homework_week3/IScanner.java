package homework_week3;

/**
 * Created by ViTaLES on 18.07.2015.
 */
public interface IScanner {

    String next();
    int nextInt();
    String nextLine();
    boolean hasNext();
    boolean hasNextInt();
    void useDelimiter(String s);
    void close();

}
