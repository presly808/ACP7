package ua.artcode.HomeWork.Week_3;


import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.InputMismatchException;

/**
 * Created by HOME on 17.07.2015.
 */
public class MyScanner implements IMyScanner {

    private Reader input;
    private String delimetr;
    private char[]buff = new char[1024];
    private int startPos=0;
    private int endPos=0;



    public MyScanner(String sourse) {
        input = new StringReader(sourse);
    }

    public MyScanner(Reader input) {
        this.input = input;
    }

    public void fillnBuff(){
        try {
            endPos=input.read(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String next() {
        if (startPos>=endPos){
            fillnBuff();
        }
       String next ="";
       int iter = startPos;
        while (iter < endPos && buff[iter] != ' '){
            if(startPos==buff.length){
                fillnBuff();
                iter=0;
            }
            next += buff[iter];
            iter++;
        }
        startPos = iter + 1;
        return next.isEmpty()?null:next;
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
    public boolean hasNextInt() throws InputMismatchException{
        return false;
    }

    @Override
    public void useDelimiter(String line) {

    }

    @Override
    public void close() throws IOException{

    }
}
