package ua.artcode.week4.ua;

import java.io.*;
import java.net.URL;

/**
 * Created by Daryna on 22-Jul-15.
 */
public class FileDownloader {

    public void download(String url, String path, String name) throws IOException {


        InputStream in = new BufferedInputStream(new URL(url).openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int n = 0;
        System.out.println("Downloading...");
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();

        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(new File(path + "\\" + "downloads\\" + name));
        System.out.println(url);
        fos.write(response);
        fos.close();

    }
}
