package week2.myFileHelper;

import java.io.*;

/**
 * Created by Джек on 11.07.2015.
 */
public class MyFileHelper implements FileHelper {

    File file;

    public MyFileHelper(File file) {
        this.file = file;
    }

    @Override
    public void help() {
       InputStream is = null;

        try {
            is = new FileInputStream("C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\Commands.txt");

            readFullyByBytes(is);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null)
                    is.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFullyByBytes (InputStream is) throws IOException {
        int oneByte;
        while ((oneByte = is.read()) != -1) {
            System.out.print((char) oneByte);
        }
    }
}
