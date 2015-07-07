package ua.artcode.week2.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by HOME on 05.07.2015.
 */
public class IOUtils {
    public static void save(String source, String path)throws FileNotFoundException{
        OutputStream os=null;
        try {
            os = new FileOutputStream(path);
            byte[] arr = source.getBytes();
            os.write(arr);
            os.close();

        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(os!=null){
                    os.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
