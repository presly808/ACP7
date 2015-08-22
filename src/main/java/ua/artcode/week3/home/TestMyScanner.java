package ua.artcode.week3.home;

/**
 * Created by serhii on 18.07.15.
 */
public class TestMyScanner {


    public static void main(String[] args) {
        IScanner scanner = new MyScanner("some text line1 line2");
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
    }
}
