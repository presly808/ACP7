package ua.artcode.HomeWork.Week_3;

import java.io.FileReader;
import java.io.Reader;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
/*
   String next() - ������ ������ ����� � ������
   int nextInt() - ������ ������ ����� �� ������ ��� InputMismatchException
   String nextLine() - ������ ���� ������
   boolean hasNext() - ����������� ������� � ������ ������
   boolean hasNextInt() - ����������� ������� � ������ ������ int �����
   useDelimiter(String) - ���������� �����������
   close() - �������� ��������, ������ ������ ������������ � NoSuchElementException
*/

/**
 * Created by HOME on 17.07.2015.
 */
public class MyScanner implements IMyScanner{

    Object obj;
    /*
    public static Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");
    public MyScanner(FileReader fr) {
        this(Objects.requireNonNull(fr, "source"), WHITESPACE_PATTERN);
    }
    */


    @Override
    public String next() {
        return null;
    }

    @Override
    public int nextInt() {
        return 0;
    }

    @Override
    public String nextLine() {
      return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasNextInt() {
        return false;
    }

    @Override
    public void useDelimiter(String line) {

    }

    @Override
    public void close() {

    }
}
