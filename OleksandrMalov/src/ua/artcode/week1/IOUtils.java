package ua.artcode.week1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Олександр on 05.07.2015.
 */
public class IOUtils {

    public static void save(String source, String path) throws FileNotFoundException{
        OutputStream os = null;
        try {
            os = new FileOutputStream("C:\\Users\\Олександр\\IdeaProjects\\ACP7\\temp/test.txt");
            byte[] arr = source.getBytes();
            os.write(arr);
            os.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if( os != null)
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
