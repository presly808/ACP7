package ua.artcode.week2.io;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestIO {

    public static final String PATH = "/home/serhii/dev/IdeaProjects/ACP7/temp/test.txt";

    public static void main(String[] args) throws FileNotFoundException {
        IOUtils.save("some text Сер Беллобров ", PATH);

        Scanner sc = new Scanner(System.in);
        System.out.print("C:\\>");
        String command = sc.nextLine();

        System.out.println(command);
    }
}
