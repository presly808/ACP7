package Consol;

import java.io.*;

/**
 * Created by Legion on 06.07.2015.
 */
public class MyFileClass {
public static String read (String fileName) throws FileNotFoundException{
    StringBuilder sb = new StringBuilder();
    exists(fileName);
    try{
        BufferedReader brIn = new BufferedReader(new FileReader(fileName));
        String s;
        while((s=brIn.readLine())!=null){
            sb = sb.append(s);
            sb = sb.append("\n");
        } brIn.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
    return sb.toString();
}
    private static void exists (String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        if (file.exists()) new FileNotFoundException(file.getName());
    }
}
