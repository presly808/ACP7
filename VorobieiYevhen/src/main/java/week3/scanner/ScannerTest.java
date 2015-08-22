package week3.scanner;

import java.io.Reader;
import java.util.Scanner;

/**
 * Created by Джек on 14.07.2015.
 */
public class ScannerTest {

    public static void main(String[] args) {


        String s = "ddd ffffish 1f11 fish52";

       MyScanner scannerReader = new MyScanner(s);


        System.out.println(scannerReader.next());

        System.out.println(scannerReader.next());
        scannerReader.useDelimiter("fish");
        scannerReader.close();
        System.out.println(scannerReader.next());
        System.out.println(scannerReader.hasNextInt());
        int a = scannerReader.nextInt();
        System.out.println(a);



    }
}
