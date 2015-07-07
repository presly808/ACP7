package ua.artcode.week2.io;

import java.io.FileNotFoundException;

/**
 * Created by HOME on 05.07.2015.
 */
public class TestIO {
    public static final String PATH = "C:/Java/ACP7/MakarenkoArtem/src/ua/artcode/tmp/file1.txt " ;
    public static void main(String[] args) throws FileNotFoundException {
        IOUtils.save("text",PATH);
    }
}
