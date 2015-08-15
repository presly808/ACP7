package week4.thread.ex_ua_downloader;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vorobiei on 24.07.2015.
 */
public class FIleLoader {
    private static final String PATH = "D:\\Новая папка (2)\\";
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
        long start = System.currentTimeMillis();
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
        long finish = System.currentTimeMillis();
        System.out.println("File " + entry.getValue() + " loading complete!\nFile size - " + new File(PATH + entry.getValue()).length()/1024 + " Kb." + " Time passed - " + (finish - start)/1000.0 + " sec.");
        fileOutputStream.close();
        in.close();
    }
}
