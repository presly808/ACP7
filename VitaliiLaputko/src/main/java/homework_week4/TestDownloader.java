package homework_week4;

import java.io.File;

/**
 * Created by ViTaLES on 24.07.2015.
 */
public class TestDownloader {

    public static void main(String[] args) {
        Downloader.downloadFileFromURL("http://www.ex.ua/92738294?r=1990,23775", new File("E:\\ArtCodePro\\ACP7\\VitaliiLaputko\\src\\1.txt"));

    }

}
