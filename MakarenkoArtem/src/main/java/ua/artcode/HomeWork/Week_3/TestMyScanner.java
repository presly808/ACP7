package ua.artcode.HomeWork.Week_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by HOME on 17.07.2015.
 */
public class TestMyScanner {
    public static void main(String[] args) {
    //String filename = "C:/Java/Test.txt ";
        IMyScanner scanner = new MyScanner("some text line line2")  ;
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
    }

}
