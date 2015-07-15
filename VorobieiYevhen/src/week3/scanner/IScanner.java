package week3.scanner;

/**
 * Created by Джек on 14.07.2015.
 */
public interface IScanner {

    String next();// - чтение одного слова в строке
    int nextInt();// - чтение целого числа из строки или InputMismatchException
    String nextLine();// - чтение всей строки
    boolean hasNext();// - определение наличия в потоке данных
    boolean hasNextInt();// - определение наличия в потоке целого int числа
    void useDelimiter(String delimiter);// - использует разделитель
    void close();// - закрытие сканнера, теперь нельзя использовать и NoSuchElementException

}
