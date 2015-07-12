package ua.artcode.week3;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        MyScanner s = new MyScanner(" 123 we1  dwd                  qw");
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.nextLine());


        Scanner sc = new Scanner("     5erf    23  4456564 4dasd  34   asd");
        System.out.println(sc.nextInt());
        System.out.println(sc.nextInt());




    }
}
