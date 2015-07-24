package week4.thread.ex_ua_downloader;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vorobiei on 24.07.2015.
 */
public class FIleLoader {
    private static final String PATH = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\downloads\\";
    private static final String SITE ="http://www.ex.ua";
    private HashMap<String, String> linksOnFiles;

    public FIleLoader(HashMap<String, String> linksOnFiles) {
        this.linksOnFiles = linksOnFiles;
    }
    public void downloadFiles() throws IOException {
        for (Map.Entry<String, String> entry : linksOnFiles.entrySet()) {

            //loadFile(entry);
            new Thread(new ThreadLoader(entry)).start();

        }
    }
    private class ThreadLoader implements Runnable {
        private Map.Entry<String, String> entry;

        public ThreadLoader(Map.Entry<String, String> entry) {
            this.entry = entry;
        }

        @Override
        public void run() {
            try {
                loadFile(entry);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void loadFile(Map.Entry<String, String> entry) throws IOException {
        System.out.println("Loading... " + entry.getValue());
        URL url = new URL(SITE + entry.getKey());
        //URLConnection connection = url.openConnection(); difference?
        InputStream in = new BufferedInputStream(url.openStream());
        File file = new File(PATH + entry.getValue());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] buff = new byte[10 * 1024 * 1024];
        int count;
        while ((count = in.read(buff)) != -1) {
            fileOutputStream.write(buff, 0, count);

        }
        fileOutputStream.close();
        in.close();
    }
}
