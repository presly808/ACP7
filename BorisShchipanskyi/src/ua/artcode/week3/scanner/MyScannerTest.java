package ua.artcode.week3.scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Created by boris on 7/16/15.
 */
public class MyScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
        MyScanner scanner = new MyScanner(new FileReader("/Users/boris/myProjects/ACP7/BorisShchipanskyi/src/ua/artcode/week3/scanner/myScannerTestFile.txt"));
        scanner.useDelimiter(",");
//        scanner.hasNext();
//        System.out.print(scanner.next());
//        System.out.println();
//        System.out.print(scanner.nextLine());
//        System.out.print(scanner.nextLine());
//        System.out.print(scanner.nextLine());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
//
//        System.out.println(toInt("5"));
//        System.out.println(toInt("5"));
//        System.out.println(toInt("-5"));
    }

    public static int toInt(String s) {
        return Integer.valueOf(s);
    }
}
