package MyScannerWeek3;


import Consol.MyFileClass;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Legion on 13.07.2015.
 */
public class MyScanner implements Iterator<String>, Closeable {
    private Object object;

    private int numberOfMethod;

    public MyScanner(Object object) {
        this.object = object;
    }

    private void vtfObject(){
        if (object.getClass()==String.class) {numberOfMethod = 0;}
        // else if (object.getClass()==Integer.class) {numberOfMethod = 2;}
        else if (object.getClass()==File.class) {numberOfMethod = 1;}
    }

    //   private String vtf (Object object){
    //    if (object.)
    //}





    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public String next() {
        vtfObject();
        String stringol = null;
        switch (numberOfMethod){
            case 0:
                String [] string = ((String) object).split(" ");
                stringol = string[0];
                break;
            case 1 :
                try {
                    String stringFile = ((String) object);
                    MyFileClass.read(stringFile);
                    InputStream is = new FileInputStream((String)object);
                    object = is.toString().split(" ");
                    next();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

        }
       return stringol;
        //return "";
    }

    public String nextLine() {
        vtfObject();
        String stringol = null;
        switch (numberOfMethod) {
            case 0:
                String[] string = ((String) object).split("\n");
                stringol = string[0];
                break;
            case 1:
                try {
                    String stringFile = ((String) object);
                    MyFileClass.read(stringFile);
                    InputStream is = new FileInputStream((String) object);
                    object = is;
                    nextLine();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

        }

        /*
        if (object.getClass()==String.class) {
            String [] string = ((String) object).split(" ");
            stringol = string[0];
        }
        */
        return stringol;
    }


    @Override
    public void close() throws IOException {

    }

}
