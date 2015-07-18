package ua.artcode.HomeWork.Week_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by HOME on 17.07.2015.
 */
public class TestMyScanner {
    public static void main(String[] args) {

        String filename = "C:/Java/Test.txt ";
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //MyScanner scan = new MyScanner(fr);
        //String line = scan.nextLine();
        //System.out.println("Test scanner with reader "+line);


        Scanner sc = new Scanner(fr);
        sc.close();

    }

}
