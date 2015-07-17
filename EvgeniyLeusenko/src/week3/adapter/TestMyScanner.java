package week3.adapter;

import java.io.*;

/**
 * Created by Пользователь on 17.07.2015.
 */
public class TestMyScanner {
    public static void main(String[] args) throws IOException {
        MyScanner sc=new MyScanner(new FileReader("C:\\Users\\Пользователь\\Desktop\\Test.txt"));
        MyScanner scString=new MyScanner("12243 qwerty asdfg");
        String result=sc.nextLine();
        //String result=scString.nextLine();
        System.out.println(result);
        //System.out.println(sc.hasNextInt());

    }
}
