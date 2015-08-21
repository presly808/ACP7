package additional.streams;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by serhii on 24.07.15.
 */
public class IOUtils {

    public static String readAllByIS(String path) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = new FileInputStream(path);

        try {
            int byteInf = 0;
            while((byteInf = is.read()) != -1){
               stringBuilder.append((char)byteInf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();

    }

    public static String readAllByISWithBuff(String path) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = new FileInputStream(path);

        byte[] buff = new byte[1024];
        int count = 0;
        try {
            while ( (count = is.read(buff)) != -1){
                stringBuilder.append(new String(buff,0,count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();

    }


    public static void writeByOS(String path, String src) {
        OutputStream os = null;

        try {
            os = new FileOutputStream(path);
            os.write(src.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void writeByWriter(String path, String src){
/*        try (Writer wr = new FileWriter(path)) {
            wr.write(src);
            System.out.println("after write");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
