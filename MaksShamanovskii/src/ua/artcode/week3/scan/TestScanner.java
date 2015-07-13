package ua.artcode.week3.scan;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        MyScanner s = new MyScanner(" 123 we1  dwd                  qw");
        System.out.println(s.hasNextInt());
        System.out.println(s.nextInt());
        System.out.println(s.hasNextInt());
        System.out.println(s.next());
        System.out.println(s.hasNextInt());
        System.out.println(s.next());
        System.out.println(s.nextLine());
        System.out.println();








    }
}
