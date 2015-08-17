package ua.artcode.week2.fileHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by tokar on 12.07.2015.
 */
public class IOUtils {
    public static String readAll(InputStream inputStream){
        StringBuilder sb =new StringBuilder();//Imutable

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(inputStream));
        String res ="";
        String line=null;

        try {
            while((line=bf.readLine())!=null){
                sb.append(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static String write(){


        return null;

    }
}
