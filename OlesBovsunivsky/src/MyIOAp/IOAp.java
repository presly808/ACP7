package MyIOAp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Legion on 12.07.2015.
 */
public class IOAp {
    public static String readdAll (InputStream inputStream){
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(inputStream));
        String line = null;
        try {
            while ((line = bf.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
