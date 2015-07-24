package week4.threads.home.task.file.search;

import java.io.File;

/**
 * Created by Пользователь on 22.07.2015.
 */
public class FileTest {
    public static void main(String[] args) throws NoDirectoryException {
        FileSearch fileSearch=new FileSearch("news.txt",new File("D:\\SQL"));
        System.out.println(fileSearch.searchCount("news.txt", new File("D:\\SQL")).intValue());
        fileSearch.queueSearch();

        fileSearch.show();
        fileSearch.search();
    }
}
